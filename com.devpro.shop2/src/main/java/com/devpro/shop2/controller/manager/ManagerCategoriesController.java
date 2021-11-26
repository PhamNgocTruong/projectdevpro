package com.devpro.shop2.controller.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devpro.shop2.controller.BaseController;
import com.devpro.shop2.entities.Category;
import com.devpro.shop2.services.CategoriesServices;




@Controller // -> controller

public class ManagerCategoriesController extends BaseController{
	
	
	@Autowired
	private CategoriesServices categoriesServices;
	
	@RequestMapping(value = { "/admin/category" }, method = RequestMethod.GET) // -> action
	public String home(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response)
			throws IOException {
		//can lay danh sach categories tu db va tra ve view qua model
		List<Category> category = categoriesServices.findAllActive();
		
		//day xuong view de xu ly
		model.addAttribute("categories",category);
		
		// cac views se duoc dat tai thu muc: 
		return "manager/category"; // -> duong dan toi VIEW.
	}
}

