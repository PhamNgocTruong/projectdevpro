package com.devpro.shop2.controller.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devpro.shop2.controller.BaseController;
import com.devpro.shop2.entities.Products;
import com.devpro.shop2.services.ProductService;

@Controller // -> controller
public class Home extends BaseController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = { "/index" }, method = RequestMethod.GET) // -> action
	public String home(final ModelMap model,
			final HttpServletRequest request,
			final HttpServletResponse response)
			throws IOException {
		
		List<Products> producthot = productService.findbyHot();
		List<Products> productnew = productService.findbyNew();
		List<Products> productacc = productService.findbyAcc();
		// cac views se duoc dat tai thu muc: 
		
		model.addAttribute("producthot",producthot);
		model.addAttribute("productnew",productnew);
		model.addAttribute("productacc",productacc);
		return "user/index"; // -> duong dan toi VIEW.
	}

}

