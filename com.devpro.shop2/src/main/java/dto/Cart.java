package dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;



public class Cart {

	private BigDecimal totalPrice = BigDecimal.ZERO;
	private List<CartItem> cartItems = new ArrayList<CartItem>();
	private List<Users> user = new  ArrayList<Users>();
	

	public List<Users> getUser() {
		return user;
	}

	public void setUser(List<Users> user) {
		this.user = user;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

}
