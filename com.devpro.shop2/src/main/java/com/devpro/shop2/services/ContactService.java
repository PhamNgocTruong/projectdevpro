package com.devpro.shop2.services;

import org.springframework.stereotype.Service;

import com.devpro.shop2.entities.Contacts;

@Service
public class ContactService extends BaseServices<Contacts> {

	@Override
	protected Class<Contacts> clazz() {
		return Contacts.class;
	}
}



