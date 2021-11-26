package com.devpro.shop2.controller.user;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devpro.shop2.controller.BaseController;
import com.devpro.shop2.entities.Products;
import com.devpro.shop2.services.ProductService;

import dto.ProductSearch;

@Controller 
public class ProductController extends BaseController{
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = { "/product" }, method = RequestMethod.GET) 
	public String home(final ModelMap model,
			final HttpServletRequest request,
			final HttpServletResponse response)
			throws IOException {
		List<Products> product = productService.findAllActive();
		
		//day xuong view de xu ly
		model.addAttribute("product",product);
		
		return "user/product"; 
	}

	@RequestMapping(value = { "/chitietsp/{productId}" }, method = RequestMethod.GET) // -> action
	public String delProduct(final ModelMap model,
			final HttpServletRequest request,
			final HttpServletResponse response,
			@PathVariable("productId") int productId)
			throws IOException {
		
		Products products = productService.getById(productId);
		model.addAttribute("product" ,products);
		// cac views se duoc dat tai thu muc: 
		return "user/chitietsp"; // -> duong dan toi VIEW.
	}
	
	@RequestMapping(value = { "/search-product" }, method = RequestMethod.GET) // -> action
	public String searchProduct(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response)
			throws IOException {
		//can lay danh sach categories tu db va tra ve view qua model
		String keyword = request.getParameter("keyword");
		ProductSearch ps = new ProductSearch();
		ps.setKeyword(keyword);
		ps.setPage(getCurrentPage(request));
		int pagePrev = ps.getPage();
		if(pagePrev <=0) {
			pagePrev = 1;
		}
		List<Products> product = productService.search(ps);
		int pageNext = ps.getPage()+2;
		if(product.size() <= 1 ) {
			pageNext = pageNext - 1; 
		}
		
		model.addAttribute("pagePrev",pagePrev);
		model.addAttribute("pageNext", pageNext);
		model.addAttribute("product",product);
		
		// cac views se duoc dat tai thu muc: 
		return "user/product"; // -> duong dan toi VIEW.
	}
	
}
