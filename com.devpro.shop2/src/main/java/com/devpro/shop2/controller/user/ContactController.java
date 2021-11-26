package com.devpro.shop2.controller.user;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.io.File;


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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.devpro.shop2.controller.BaseController;

import dto.SimpleContact;

@Controller
public class ContactController extends BaseController {
	@RequestMapping(value= {"/contact"},method = RequestMethod.GET)
	public String contact(final ModelMap Model,
			final HttpServletRequest request,
			final HttpServletResponse response)
		
	throws IOException{
		Model.addAttribute("contact", new SimpleContact());
		return "user/contact";
	}
	
	@RequestMapping(value= {"/contact"},method = RequestMethod.POST)
	public String saveContact(final ModelMap Model,
			final HttpServletRequest request,
			final HttpServletResponse response,
			@ModelAttribute("contact") SimpleContact contact,
			@RequestParam("inputFile") MultipartFile[] inputFiles)
	throws IOException{
		//1: lay thon tin nguoi dung day len
				String email = request.getParameter("txtEmail");
				String emailFromSpringForm = contact.getTxtEmail();
				//TODO 2: luu thong tin vao co so du lieu
				
				//3: thong bao cho nguoi biet da luu thanh cong
				Model.addAttribute("thongbao", "Cam on ban "+ emailFromSpringForm+ " da gui lien he!");
				//4: save file
				if(inputFiles.length > 0) {
					for(MultipartFile inputFile : inputFiles) {
						inputFile.transferTo(new File("D:\\code\\java\\com.devpro.shop2\\upload\\"+inputFile.getOriginalFilename()));
					}
				}
				// cac views se duoc dat tai thu muc: /src/main/webapp/WEB-INF/views
				return "user/contact"; // -> duong dan toi VIEW.
				
	}
	@RequestMapping(value = { "/contact-ajax" }, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> contactAjax(final Model model , 
						final HttpServletRequest request, 
						final HttpServletResponse response, 
						final @RequestBody SimpleContact contact) {
		
		System.out.println("Contact[Email]: " + contact.getTxtEmail());

		Map<String, Object> jsonResult = new HashMap<String, Object>();
		// 200 <-> thanh cong
		// 500 <-> khong thanh cong
		jsonResult.put("code", 200);
		jsonResult.put("message", contact);
		return ResponseEntity.ok(jsonResult);
	}
}
