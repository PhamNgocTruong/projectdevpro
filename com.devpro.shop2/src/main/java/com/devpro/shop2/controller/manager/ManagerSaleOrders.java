package com.devpro.shop2.controller.manager;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devpro.shop2.controller.BaseController;
import com.devpro.shop2.entities.Category;
import com.devpro.shop2.entities.Saleorder;
import com.devpro.shop2.entities.SaleorderProducts;
import com.devpro.shop2.services.SaleOrderSercive;
import com.devpro.shop2.services.Saleorder_ProductServices;

import dto.Cart;
import dto.CartItem;

@Controller
public class ManagerSaleOrders extends BaseController{

	@Autowired
	private SaleOrderSercive saleOrderService;
	
	@Autowired
	private Saleorder_ProductServices saleorder_ProductServices;
	
	@RequestMapping(value = { "/admin/saleorder" }, method = RequestMethod.GET) // -> action
	public String home(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response)
			throws IOException {
		
		
		
		//can lay danh sach categories tu db va tra ve view qua model
		List<Saleorder> saleorder = saleOrderService.findAll();
		
		//day xuong view de xu ly
		model.addAttribute("saleorder",saleorder);
		
		
		
		// cac views se duoc dat tai thu muc: 
		return "manager/saleorder"; // -> duong dan toi VIEW.
	}
	
	
	
	@RequestMapping(value = { "/admin/del-saleorder/{id}" }, method = RequestMethod.GET) // -> action
	public String delSaleorder(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response,
			@PathVariable("id") int id)
			throws IOException {
		
		saleOrderService.deleteById(id);
		
		// cac views se duoc dat tai thu muc: 
		return "redirect:/admin/saleorder"; // -> duong dan toi VIEW.
	}
	
	/*
	 * @RequestMapping(value = { "/admin/detail-saleorder/{saleorderId}" }, method =
	 * RequestMethod.GET) // -> action public String editProduct(final Model model,
	 * final HttpServletRequest request, final HttpServletResponse response,
	 * 
	 * @PathVariable("saleorderId") int saleorderId) throws IOException {
	 * 
	 * int saleorderProductID =
	 * saleorder_ProductServices.findbySaleorderid(saleorderId);
	 * 
	 * 
	 * 
	 * //day xuong view de xu ly
	 * model.addAttribute("saleorderProduct",saleorderProduct);
	 * 
	 * 
	 * // cac views se duoc dat tai thu muc: return "manager/del_saleorderproduct";
	 * // -> duong dan toi VIEW. }
	 */
}
