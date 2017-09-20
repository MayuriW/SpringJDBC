package com.infotech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.infotech.model.User;
import com.infotech.service.UserListService;

@Controller
public class UserListController {

	@Autowired
	private UserListService userListService;
	
	
	@RequestMapping(value="/UserList",method=RequestMethod.POST)
	public ModelAndView getUserList(ModelAndView modelAndView)	
	{	
		List<User> userList = userListService.getUserList();
		//ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("UserList");
		modelAndView.addObject("UserList",userList); // object name and value passed
		return modelAndView;
		
	}
	
	//case 1
	@RequestMapping(value="/welcomeMsg",method=RequestMethod.POST)
	public String getMessage(/*Model model*/)
	{		 
		/*model.addAttribute("headerMsg", "Welcome to Header ...");
		model.addAttribute("welcomeMsg", "Welcome Page called ...");*/
		return "welcome";
	}
	
	//case 1 and case 3
	@ModelAttribute
	public void modelData(Model model)
	{
		model.addAttribute("headerMsg", "modelData :: Welcome to Header ...");
		model.addAttribute("welcomeMsg", "modelData :: Welcome Page called ...");	
	}
	
	//case 2
	/*@RequestMapping(value="/welcomeMsg",method=RequestMethod.POST)
	public String getMessage(Map<String, String> model)
	{		 
		model.put("headerMsg", "Welcome to Header using map ...");
		model.put("welcomeMsg", "Welcome Page called using map...");
		return "welcome";
	}*/

}
