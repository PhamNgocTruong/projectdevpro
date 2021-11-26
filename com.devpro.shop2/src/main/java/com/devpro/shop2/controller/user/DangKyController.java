package com.devpro.shop2.controller.user;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devpro.shop2.controller.BaseController;
import com.devpro.shop2.entities.Category;
import com.devpro.shop2.entities.Users;
import com.devpro.shop2.services.CategoriesServices;
import com.devpro.shop2.services.UserService;
@Controller
public class DangKyController extends BaseController{
	@Autowired
	private UserService userService;

	/*
	 * @RequestMapping(value = { "/dki" }, method = RequestMethod.GET) public String
	 * home(final ModelMap model, final HttpServletRequest request, final
	 * HttpServletResponse response) throws IOException {
	 * 
	 * 
	 * return "user/dki"; }
	 */
	@RequestMapping(value = { "/dki" }, method = RequestMethod.GET) // -> action
	public String user(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response)
			throws IOException {
		
		List<Users> user = userService.findAll();
		//day xuong view de xu ly
		model.addAttribute("users",new Users());
		
		
		// cac views se duoc dat tai thu muc: 
		return "user/dki"; // -> duong dan toi VIEW.
	}
	@RequestMapping(value= {"/dki"},method = RequestMethod.POST)
	public String addUsers(final Model Model,
			final HttpServletRequest request,
			final HttpServletResponse response,
			@ModelAttribute("users")  Users users)
			
	throws Exception{
		
				//kiểm tra xem action là thêm mới hay chỉnh sửa
				userService.save(users);
		
				/*
				 * if(users.getId()==null||users.getId()<=0) { userService.save(users); } else {
				 * userService.edit(users); }
				 */
		 
				 
			
				return "login"; 			
	}
	
}
