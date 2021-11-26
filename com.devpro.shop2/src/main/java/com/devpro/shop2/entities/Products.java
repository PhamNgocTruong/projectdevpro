package com.devpro.shop2.entities;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_products")
public class Products extends BaseEntity{
	@Column(name="title",length=1000,nullable=false)
	private String title;
	
	@Column(name = "price", precision = 13, scale = 2, nullable = false)
	private BigDecimal price;
	
	@Column(name = "price_sale", precision = 13, scale = 2, nullable = true)
	private BigDecimal price_sale;
	
	@Column(name="short_description",length=3000,nullable=false)
	private String short_description;
	
	@Lob
	@Column(name = "detail_description", nullable = false, columnDefinition = "LONGTEXT")
	private String details;
	
	@Column(name="avatar",length=200,nullable=true)
	private String avatar;
	
	@Column(name="seo",length=1000,nullable=true)
	private String seo;
	
	@Column(name="is_hot", nullable = true)
	private Boolean is_hot = Boolean.FALSE;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id")
	private Category categories;
	
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "products")
	private Set<ProductsImages> productimages = new HashSet<ProductsImages>() ;
	
	//khi dinh nghia OneToMany thi luon phai dinh nghia 2 ham quan li list
	/**
	 * them  1 san pham vao danh sach @OneToMany
	 * @param product
	 */
	public void addProductsImages(ProductsImages products) {
		productimages.add(products);
		products.setProducts(this);
	}
	/**
	 * xoa san pham khoi danh sach @OneToMany
	 * @param product
	 */
	public void deleteProductsImages(ProductsImages products) {
		productimages.remove(products);
		products.setProducts(null);
	}
	public Category getCategories() {
		return categories;
	}

	public void setCategories(Category categories) {
		this.categories = categories;
	}
	
	public Set<ProductsImages> getProductimages() {
		return productimages;
	}
	public void setProductimages(Set<ProductsImages> productimages) {
		this.productimages = productimages;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getPrice_sale() {
		return price_sale;
	}

	public void setPrice_sale(BigDecimal price_sale) {
		this.price_sale = price_sale;
	}

	public String getShort_description() {
		return short_description;
	}

	public void setShort_description(String short_description) {
		this.short_description = short_description;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getSeo() {
		return seo;
	}

	public void setSeo(String seo) {
		this.seo = seo;
	}

	public Boolean getIs_hot() {
		return is_hot;
	}

	public void setIs_hot(Boolean is_hot) {
		this.is_hot = is_hot;
	}
	
	
}
