package com.devpro.shop2.controller.user;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devpro.shop2.controller.BaseController;
import com.devpro.shop2.entities.Products;
import com.devpro.shop2.entities.Saleorder;
import com.devpro.shop2.entities.SaleorderProducts;
import com.devpro.shop2.entities.Users;
import com.devpro.shop2.services.ProductService;
import com.devpro.shop2.services.SaleOrderSercive;

import dto.Cart;
import dto.CartItem;

@Controller
public class CartController extends BaseController {

	
	@Autowired
	SaleOrderSercive saleOrderService;
	@Autowired
	ProductService productService;
	
	@RequestMapping(value = { "/cart/finish" }, method = RequestMethod.POST)
	public String cartFinish(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response)
			throws Exception {

		String customerName = request.getParameter("customerName");
		String customerAddress = request.getParameter("customerAddress");
		String customerPhone = request.getParameter("customerPhone");
		String customerEmail = request.getParameter("customerEmail");
		
		//tạo hóa đơn
		Saleorder saleOrder = new Saleorder();
		saleOrder.setCustomerName(customerName);
		saleOrder.setCutomerEmail(customerEmail);
		saleOrder.setCustomerPhone(customerPhone);
		saleOrder.setCustomerAddress(customerAddress);
		saleOrder.setCode(String.valueOf(System.currentTimeMillis()));
		if(getUserLogined()!= null) {
			saleOrder.setUser(getUserLogined());
			
		}

		//kết các sản phẩm trong giỏ hàng cho hóa đơn
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		for(CartItem cartItem : cart.getCartItems()) {
			SaleorderProducts saleOrderProducts = new SaleorderProducts();
			saleOrderProducts.setProduct(productService.getById(cartItem.getProductId()));
			saleOrderProducts.setQuality(cartItem.getQuanlity());
			saleOrder.addRelationSaleorder_products(saleOrderProducts);
		}
		
		//lưu vào cơ sở dữ liệu
		saleOrderService.saveOrUpdate(saleOrder);
		session.setAttribute("cart", null);
		session.setAttribute("message", "Cảm ơn bạn đã mua hàng, chúng tôi sẽ liên hệ với bạn sau!");
		
		return "user/view-cart";
	}
	
	@RequestMapping(value = { "/cart/view" }, method = RequestMethod.GET)
	public String indexxx(final ModelMap model, final HttpServletRequest request,
			final HttpServletResponse response)
	throws Exception{
		return "user/view-cart";
	}
	
	@RequestMapping(value = { "/cart/add" }, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> addToCart(final ModelMap model, final HttpServletRequest request,
			final HttpServletResponse response, @RequestBody CartItem newItem) {

		// session tương tự như kiểu Map và được lưu trên main memory.
		HttpSession session = request.getSession();

		// Lấy thông tin giỏ hàng.
		Cart cart = null;
		if (session.getAttribute("cart") != null) {
			cart = (Cart) session.getAttribute("cart");
		} else {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}

		// Lấy danh sách sản phẩm có trong giỏ hàng
		List<CartItem> cartItems = cart.getCartItems();

		// kiểm tra nếu có trong giỏ hàng thì tăng số lượng
		boolean isExists = false;
		for (CartItem item : cartItems) {
			if (item.getProductId() == newItem.getProductId()) {
				isExists = true;
				item.setQuanlity(item.getQuanlity() + newItem.getQuanlity());
			}
		}

		// nếu sản phẩm chưa có trong giỏ hàng
		if (!isExists) {
			Products productInDb = productService.getById(newItem.getProductId());

			newItem.setProductName(productInDb.getTitle());
			newItem.setPriceUnit(productInDb.getPrice());
			cart.getCartItems().add(newItem);
		}
		
		// trả kết quả
		Map<String, Object> jsonResult = new HashMap<String, Object>();
		jsonResult.put("code", 200);
		jsonResult.put("status", "TC");
		jsonResult.put("totalItems", getTotalItems(request));
		
		session.setAttribute("totalItems", getTotalItems(request));
		return ResponseEntity.ok(jsonResult);
	}

	private int getTotalItems(final HttpServletRequest request) {
		HttpSession httpSession = request.getSession();

		if (httpSession.getAttribute("cart") == null) {
			return 0;
		}

		Cart cart = (Cart) httpSession.getAttribute("cart");
		List<CartItem> cartItems = cart.getCartItems();

		int total = 0;
		for (CartItem item : cartItems) {
			total += item.getQuanlity();
		}

		return total;
	}
	
}
