package com.devpro.shop2.controller.manager;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devpro.shop2.controller.BaseController;
import com.devpro.shop2.entities.Products;
import com.devpro.shop2.services.ProductService;

import dto.ProductSearch;


@Controller // -> controller
public class ManagerProductsController extends BaseController{
	@Autowired
	private ProductService productService;
	
	
	@RequestMapping(value = { "/admin/product" }, method = RequestMethod.GET) // -> action
	public String product(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response)
			throws IOException {
		//can lay danh sach categories tu db va tra ve view qua model
		List<Products> product = productService.findAll();
		
		//day xuong view de xu ly
		
		
		model.addAttribute("product",product);
		
		// cac views se duoc dat tai thu muc: 
		return "manager/product"; // -> duong dan toi VIEW.
	}
	@RequestMapping(value = { "/admin/search-product" }, method = RequestMethod.GET) // -> action
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
		return "manager/product"; // -> duong dan toi VIEW.
	}
	

}
