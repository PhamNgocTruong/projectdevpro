package com.devpro.shop2.controller.manager;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.devpro.shop2.controller.BaseController;
import com.devpro.shop2.entities.Category;
import com.devpro.shop2.entities.Products;
import com.devpro.shop2.services.CategoriesServices;
import com.devpro.shop2.services.ProductService;

import dto.ProductSearch;

@Controller
public class ManagerAddProductController extends BaseController{
	@Autowired
	private CategoriesServices categoriesServices;
	@Autowired
	private ProductService productService;
//	
//	@RequestMapping(value = { "/manager/product" }, method = RequestMethod.GET) // -> action
//	public String productmanager(final Model model,
//			final HttpServletRequest request,
//			final HttpServletResponse response)
//			throws IOException {
//		//can lay danh sach categories tu db va tra ve view qua model
//		List<Products> product = productService.findAll();
//		
//		//day xuong view de xu ly
//		
//		
//		model.addAttribute("product",product);
//		
//		// cac views se duoc dat tai thu muc: 
//		return "manager/product"; // -> duong dan toi VIEW.
//	}
	
	@RequestMapping(value = { "/admin/addproduct" }, method = RequestMethod.GET) // -> action
	public String product(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response)
			throws IOException {
		
		List<Category> category = categoriesServices.findAllActive();
		//day xuong view de xu ly
		model.addAttribute("categories",category);
		
		model.addAttribute("product",new Products());
		
		// cac views se duoc dat tai thu muc: 
		return "manager/addproduct"; // -> duong dan toi VIEW.
	}
	
	@RequestMapping(value = { "/admin/edit-product/{productSeo}" }, method = RequestMethod.GET) // -> action
	public String editProduct(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response,
			@PathVariable("productSeo") String productSeo)
			throws IOException {
		
		//lay san pham  tu databases
		ProductSearch productSearch = new ProductSearch();
		productSearch.setSeo(productSeo);
		Products product = productService.search(productSearch).get(0);
		
		//lay danh sach category
		List<Category> category = categoriesServices.findAllActive();
		//day xuong view de xu ly
		model.addAttribute("categories",category);
		
		model.addAttribute("product",product);
		
		// cac views se duoc dat tai thu muc: 
		return "manager/addproduct"; // -> duong dan toi VIEW.
	}
	@RequestMapping(value= {"/admin/addproduct"},method = RequestMethod.POST)
	public String addProduct(final Model Model,
			final HttpServletRequest request,
			final HttpServletResponse response,
			@ModelAttribute("product") Products product,
			@RequestParam("ProductAvatar") MultipartFile ProductAvatar,
			@RequestParam("productPictures") MultipartFile[] productPictures)
	throws Exception{
		
				
				//kiểm tra xem action là thêm mới hay chỉnh sửa
				if(product.getId()== null||product.getId()<=0) {
						productService.save(product,ProductAvatar,productPictures);
				}else {
					productService.edit(product,ProductAvatar,productPictures);

				}
			
				return "redirect:/admin/search-product?page=1" ;	
		}

	@RequestMapping(value = { "/admin/del-product/{id}" }, method = RequestMethod.GET) // -> action
	public String delProduct(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response,
			@PathVariable("id") int id)
			throws IOException {
		
		productService.deleteById(id);
		
		// cac views se duoc dat tai thu muc: 
		return "redirect:/admin/search-product?page=1"; // -> duong dan toi VIEW.
	}
	
}

