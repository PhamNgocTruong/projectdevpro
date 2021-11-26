package com.devpro.shop2.controller.user;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devpro.shop2.controller.BaseController;

@Controller
public class LoginController extends BaseController{
	@RequestMapping(value = {"/login"}, method = RequestMethod.GET)
	public String home(final ModelMap model,
			final HttpServletRequest request, 
			final HttpServletResponse response)
	throws IOException{
		return "login";
	}
}