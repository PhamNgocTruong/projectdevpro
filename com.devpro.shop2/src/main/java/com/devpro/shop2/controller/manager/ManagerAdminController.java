package com.devpro.shop2.controller.manager;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devpro.shop2.controller.BaseController;


@Controller // -> controller

public class ManagerAdminController extends BaseController{

	@RequestMapping(value = { "/admin/giaodienadmin" }, method = RequestMethod.GET) // -> action
	public String home(final ModelMap model,
			final HttpServletRequest request,
			final HttpServletResponse response)
			throws IOException {
		
		// cac views se duoc dat tai thu muc: 
		return "manager/giaodienadmin"; // -> duong dan toi VIEW.
	}
}
