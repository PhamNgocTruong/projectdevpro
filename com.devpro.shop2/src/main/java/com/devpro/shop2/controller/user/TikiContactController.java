package com.devpro.shop2.controller.user;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devpro.shop2.controller.BaseController;

import dto.SimleTikiContact;
import dto.SimpleContact;

@Controller
public class TikiContactController extends BaseController {
	@RequestMapping(value= {"/tikicontact"},method = RequestMethod.GET)
	public String contact(final ModelMap Model,
			final HttpServletRequest request,
			final HttpServletResponse response)
		
	throws IOException{
		Model.addAttribute("tikicontact", new SimleTikiContact());
		return "user/tikicontact";
	}
	
	@RequestMapping(value= {"/tikicontact"},method = RequestMethod.POST)
	public String saveTikiContact(final ModelMap Model,
			final HttpServletRequest request,
			final HttpServletResponse response,
			@ModelAttribute("tikicontact") SimleTikiContact tikicontact)
	throws IOException{
				//1: lay thong tin nguoi dung day len
				String email = request.getParameter("txtEmail");
				String emailFromSpringForm = tikicontact.getTxtEmail();
				//TODO 2: luu thong tin vao co so du lieu
				
				//3: thong bao cho nguoi biet da luu thanh cong
				Model.addAttribute("thongbao", "Cam on ban "+ emailFromSpringForm+ " da gui lien he!");
				
				
				return "user/tikicontact";
	}
	@RequestMapping(value = { "/tikicontact-ajax" }, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> contactAjax(final Model model , 
						final HttpServletRequest request, 
						final HttpServletResponse response, 
						final @RequestBody SimleTikiContact tikicontact) {
		System.out.println("TikiContact[MainSupport]: " + tikicontact.getTxtmainsp());
		System.out.println("TikiContact[DetailSupport]: " + tikicontact.getTxtdetailsp());
		System.out.println("TikiContact[Email]: " + tikicontact.getTxtEmail());
		System.out.println("TikiContact[Phone]: " + tikicontact.getTxtPhone());
		System.out.println("TikiContact[ID]: " + tikicontact.getTxtID());
		System.out.println("TikiContact[Title]: " + tikicontact.getTxtTitle());
		System.out.println("TikiContact[Content]: " + tikicontact.getTxtContent());

		Map<String, Object> jsonResult = new HashMap<String, Object>();

		jsonResult.put("code", 200);
		jsonResult.put("message", tikicontact);
		return ResponseEntity.ok(jsonResult);
	}

}
