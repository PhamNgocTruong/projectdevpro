package com.devpro.shop2.controller.manager;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devpro.shop2.controller.BaseController;
import com.devpro.shop2.entities.Contacts;
import com.devpro.shop2.services.ContactService;


@Controller
public class ManagerContactController extends BaseController{
	@Autowired
	private ContactService contactService;
	
	@RequestMapping(value = { "/admin/contact" }, method = RequestMethod.GET) // -> action
	public String home(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response)
			throws IOException {
		//can lay danh sach contact tu db va tra ve view qua model
		List<Contacts> contact = contactService.findAll();
		
		//day xuong view de xu ly
		model.addAttribute("contact",contact);
		
		// cac views se duoc dat tai thu muc: 
		return "manager/contact"; // -> duong dan toi VIEW.
	}
}



