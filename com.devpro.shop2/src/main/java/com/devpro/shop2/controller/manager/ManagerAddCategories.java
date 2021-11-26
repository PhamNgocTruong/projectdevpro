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
@Controller
public class ManagerAddCategories extends BaseController{
	@Autowired
	private CategoriesServices categoriesServices;
	@RequestMapping(value = { "/admin/addcategories" }, method = RequestMethod.GET) // -> action
	public String product(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response)
			throws IOException {
		
		List<Category> category = categoriesServices.findAll();
		//day xuong view de xu ly
		model.addAttribute("categories",new Category());
		
		
		// cac views se duoc dat tai thu muc: 
		return "manager/addcategories"; // -> duong dan toi VIEW.
	}
	
	@RequestMapping(value = { "/admin/edit-category/{categoryId}" }, method = RequestMethod.GET) // -> action
	public String editProduct(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response,
			@PathVariable("categoryId") int categoryId)
			throws IOException {
		
		Category category = categoriesServices.getById(categoryId);
		
		//lay danh sach category
		
		//day xuong view de xu ly
		model.addAttribute("categories",category);
		
		
		// cac views se duoc dat tai thu muc: 
		return "manager/addcategories"; // -> duong dan toi VIEW.
	}
	
	@RequestMapping(value= {"/admin/addcategories"},method = RequestMethod.POST)
	public String addProduct(final Model Model,
			final HttpServletRequest request,
			final HttpServletResponse response,
			@ModelAttribute("categories") Category category)
			
	throws Exception{
		
				
				//kiểm tra xem action là thêm mới hay chỉnh sửa
				if(category.getId()==null||category.getId()<=0) {
					categoriesServices.save(category);
				}else {
					categoriesServices.edit(category);

				}
			
				return "manager/addcategories"; 			
	}
	
	@RequestMapping(value = { "/admin/del-categories/{id}" }, method = RequestMethod.GET) // -> action
	public String delProduct(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response,
			@PathVariable("id") int id)
			throws IOException {
		
		categoriesServices.deleteById(id);
		
		// cac views se duoc dat tai thu muc: 
		return "redirect:/admin/category"; // -> duong dan toi VIEW.
	}
}
