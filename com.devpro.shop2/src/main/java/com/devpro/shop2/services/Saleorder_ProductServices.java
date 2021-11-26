package com.devpro.shop2.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devpro.shop2.entities.Products;
import com.devpro.shop2.entities.SaleorderProducts;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
@Service
public class Saleorder_ProductServices extends BaseServices<SaleorderProducts>{

	@Override
	protected Class<SaleorderProducts> clazz() {
		// TODO Auto-generated method stub
		return SaleorderProducts.class;
	}
	/*
	 * public int findbySaleorderid(int saleorderId) { String sql =
	 * "SELECT id FROM tbl_saleorder_products WHERE saleorder_id = saleorderId";
	 * return ; }
	 */
}
