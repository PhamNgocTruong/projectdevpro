package com.devpro.shop2.services;

import org.springframework.stereotype.Service;

import com.devpro.shop2.entities.Saleorder;

@Service
public class SaleOrderSercive extends BaseServices<Saleorder>{

	@Override
	protected Class<Saleorder> clazz() {
		return Saleorder.class;
	}
	
}
