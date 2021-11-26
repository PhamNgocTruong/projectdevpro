package com.devpro.shop2.services;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.devpro.shop2.entities.Category;
import com.devpro.shop2.entities.Products;
import com.devpro.shop2.entities.ProductsImages;

@Service
public class CategoriesServices extends BaseServices<Category> {

	@Override
	protected Class<Category> clazz() {
		return Category.class;
	}
	
	public List<Category> findAllActive(){
		String sql ="select*from tbl_category where status =1";
		return super.executeNativeSql(sql,-1);
	}
	
	@Transactional
	public  Category edit(Category category) throws Exception {
		//lay category tu database
		Category categoryOnDb= super.getById(category.getId());
		
		return super.saveOrUpdate(category);
	}
	
	@Transactional
	public  Category save(Category category) throws Exception {
		
		return super.saveOrUpdate(category);
	}
}
