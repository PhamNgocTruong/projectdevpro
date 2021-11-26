package com.devpro.shop2.entities;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_saleorder")
public class Saleorder extends BaseEntity{
	@Column(name="code" , length= 45 , nullable = false)
	private String code;
	
	
	@Column(name = "total", precision = 13, scale = 2, nullable = true)
	private BigDecimal total;
	
	@Column(name="customer_name" , length= 100 , nullable = true)
	private String customerName;
	
	@Column(name="customer_address" , length= 100 , nullable = true)
	private String customerAddress;
	
	@Column(name="seo" , length= 200 , nullable = true)
	private String seo;
	
	@Column(name="customer_phone" , length= 100 , nullable = true)
	private String customerPhone;
	
	@Column(name="cutomer_email" , length= 100 , nullable = true)
	private String cutomerEmail;
	
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "saleorder")
	private Set<SaleorderProducts>saleorder_products = new HashSet<SaleorderProducts>();
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="user_id")
	private Users user;
	/**
	 * them  1 san pham vao danh sach @OneToMany
	 * @param product
	 */
	public void addRelationSaleorder_products(SaleorderProducts saleorder_product) {
		saleorder_products.add(saleorder_product);
		saleorder_product.setSaleorder(this);
	}

	/**
	 * xoa san pham khoi danh sach @OneToMany
	 * @param product
	 */
	public void deleteRelationSaleorder_products(SaleorderProducts saleorder_product) {
		saleorder_products.remove(saleorder_product);
		saleorder_product.setSaleorder(null);
	}
	
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getSeo() {
		return seo;
	}

	public void setSeo(String seo) {
		this.seo = seo;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCutomerEmail() {
		return cutomerEmail;
	}

	public void setCutomerEmail(String cutomerEmail) {
		this.cutomerEmail = cutomerEmail;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	
	
	
	
}
