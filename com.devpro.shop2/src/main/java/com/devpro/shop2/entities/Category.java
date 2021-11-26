package com.devpro.shop2.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity 
@Table(name="tbl_category")
public class Category extends BaseEntity{
	@Column(name="name",length = 100,nullable=false)
	private String name;
	
	@Column(name="description",length = 100, nullable = false)
	private String description;
	
	@Column(name="seo",length = 1000,nullable=true)
	private String seo;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "categories")
	private Set<Products> products = new HashSet<Products>() ;
	
	//khi dinh nghia OneToMany thi luon phai dinh nghia 2 ham quan li list
	/**
	 * them  1 san pham vao danh sach @OneToMany
	 * @param product
	 */
	public void addRelationProduct(Products product) {
		products.add(product);
		product.setCategories(this);
	}
	/**
	 * xoa san pham khoi danh sach @OneToMany
	 * @param product
	 */
	public void deleteRelationProduct(Products product) {
		products.remove(product);
		product.setCategories(null);
	}
	
	
	public Set<Products> getProducts() {
		return products;
	}

	public void setProducts(Set<Products> products) {
		this.products = products;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSeo() {
		return seo;
	}

	public void setSeo(String seo) {
		this.seo = seo;
	}
}
