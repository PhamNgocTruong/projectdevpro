package com.devpro.shop2.services;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.devpro.shop2.entities.Products;
import com.devpro.shop2.entities.ProductsImages;

import dto.Constants;
import dto.ProductSearch;

@Service
public class ProductService extends BaseServices<Products> implements Constants{

	@Override
	protected Class<Products> clazz() {
		return Products.class;
	}

	public  List<Products> findAllActive() {
		String sql = "SELECT * FROM tbl_products WHERE status = 1";
		return super.executeNativeSql(sql, -1);
	}
	public  List<Products> findbyHot() {
		String sql = "SELECT * FROM tbl_products WHERE category_id = 22";
		return super.executeNativeSql(sql, -1);
	}
	
	public  List<Products> findbyNew() {
		String sql = "SELECT * FROM tbl_products WHERE category_id = 28";
		return super.executeNativeSql(sql, -1);
	}
	
	public  List<Products> findbyAcc() {
		String sql = "SELECT * FROM tbl_products WHERE category_id = 23";
		return super.executeNativeSql(sql, -1);
	}
	
	// tất cả các services cần thêm hàm search.
		public List<Products> search(ProductSearch searchModel) {

			// khởi tạo câu lệnh
			String sql = "SELECT * FROM tbl_products p WHERE 1=1";
			
			if(!StringUtils.isEmpty(searchModel.getSeo())) {
				sql += " and p.seo = '"+ searchModel.getSeo() +"'";
			}
			
			// tim kiem san pham theo seachText
			if (!StringUtils.isEmpty(searchModel.getKeyword())) {
				sql += " and (p.title like '%" + searchModel.getKeyword() + "%'" + " or p.detail_description like '%"
						+ searchModel.getKeyword() + "%'" + " or p.short_description like '%"
						+ searchModel.getKeyword() + "%')";
			}
			
			// chi lay san pham chua xoa
//			sql += " and p.status=1 ";

			return executeNativeSql(sql,searchModel.getPage());
		}
	
	
	private boolean isEmptyUploadFile(MultipartFile[] images) {
		if (images == null || images.length <= 0)
			return true;

		if (images.length == 1 && images[0].getOriginalFilename().isEmpty())
			return true;

		return false;
	}

	private boolean isEmptyUploadFile(MultipartFile image) {
		return image == null || image.getOriginalFilename().isEmpty();
	}
	
	@Transactional
	public  Products edit(Products product,MultipartFile ProductAvatar,MultipartFile[] productPictures)
			throws Exception {
		//lấy thông tin sp từ database
		Products productOnDb= super.getById(product.getId());
		
		//co day avatar len khong
		if(!isEmptyUploadFile(ProductAvatar)) {
			//xóa avatar trong folder cũ đi
			new File(UPLOAD_FOLDER_ROOT+productOnDb.getAvatar()).delete();
			//add avatar mới
			
			ProductAvatar.transferTo(new File(UPLOAD_FOLDER_ROOT+"product/avatar/"+ProductAvatar.getOriginalFilename()));
			product.setAvatar("product/avatar/"+ProductAvatar.getOriginalFilename());
		}else {
			//sử dụng lại avatar cũ
			product.setAvatar(productOnDb.getAvatar());
		}
		//co day pictures len ko
		if(!isEmptyUploadFile(productPictures)) {
			for(MultipartFile pic:productPictures) {
				pic.transferTo(new File(UPLOAD_FOLDER_ROOT+"product/pictures/"+pic.getOriginalFilename()));
				ProductsImages pi=new ProductsImages();
				pi.setPath("product/pictures/"+pic.getOriginalFilename());
				pi.setTitle(pic.getOriginalFilename());
				
				product.addProductsImages(pi);
			}
		}
		return super.saveOrUpdate(product);
	}
	
	@Transactional
	public  Products save(Products product,MultipartFile ProductAvatar,MultipartFile[] productPictures) throws Exception {
		//co day avatar len khong
		if(!isEmptyUploadFile(ProductAvatar)) {
			String pathToFile="D:\\code\\java\\com.devpro.shop2\\upload\\product\\avatar\\" +ProductAvatar.getOriginalFilename();
			ProductAvatar.transferTo(new File(pathToFile));
			product.setAvatar("product/avatar/"+ProductAvatar.getOriginalFilename());
		}
		//co day pictures len ko
		if(!isEmptyUploadFile(productPictures)) {
			for(MultipartFile pic:productPictures) {
				pic.transferTo(new File("D:\\code\\java\\com.devpro.shop2\\upload\\product\\pictures\\"+pic.getOriginalFilename()));
				ProductsImages pi=new ProductsImages();
				pi.setPath("product/pictures/"+pic.getOriginalFilename());
				pi.setTitle(pic.getOriginalFilename());
				
				product.addProductsImages(pi);
			}
		}
		return super.saveOrUpdate(product);
	}
}


