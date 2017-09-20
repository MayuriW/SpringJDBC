package com.infotech.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.infotech.model.User;
import com.infotech.service.MyUserService;

@Controller
public class ServletExampleController {
	
	Logger logger = Logger.getLogger("com.infotech.controller.ServletExampleController");
	
	@Autowired
	MyUserService myUserService ;
	
	@RequestMapping(value="/servletObject",method=RequestMethod.POST)
	public ModelAndView callServlet(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) 
			throws Exception
	{	
		User user = new User(httpServletRequest.getParameter("name"),
				Integer.parseInt(httpServletRequest.getParameter("age")),
				httpServletRequest.getParameter("email"),
				httpServletRequest.getParameter("country"));
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("registerSuccess");
		modelAndView.addObject("user", user);		
		return modelAndView;
	}
	
	@RequestMapping(value="/StringServlet",method=RequestMethod.GET)
	public ModelAndView callStringServlet(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) 
			throws Exception
	{	
		logger.info(" --- ");
		User user = new User(httpServletRequest.getParameter("name"),
				Integer.parseInt(httpServletRequest.getParameter("age")),
				httpServletRequest.getParameter("email"),
				httpServletRequest.getParameter("country"));
		
		myUserService.saveIntoMyUser(user);
		ModelAndView modelAndView = new ModelAndView("registerSuccess","user", user);
		return modelAndView;
	}

}
