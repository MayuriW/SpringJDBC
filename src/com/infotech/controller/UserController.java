package com.infotech.controller;

import java.util.HashMap;
import java.util.logging.Logger;

import javax.enterprise.inject.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.infotech.model.User;
import com.infotech.service.WelcomeService;
import com.sun.javafx.collections.MappingChange.Map;

@Controller
public class UserController {
	
	Logger logger = Logger.getLogger("com.infotech.controller.UserController");
	
	@Autowired
	private WelcomeService welcomeService ;

	@RequestMapping(value="/",method=RequestMethod.GET)
	public String registerPage(){
		return "register";
	}
	
	//to resolve domain issue -- www.yahoo.com issue 
	@RequestMapping(value="/welcome/{domainName:.+}",method=RequestMethod.GET)
	public ModelAndView welcomePage(@PathVariable ("domainName") String domainName){
		ModelAndView modelAndView = new ModelAndView("welcome","welcomeMsg","Domain Name is :: "+domainName);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/registerSuccess",method=RequestMethod.POST)
	public ModelAndView registerSuccess(@RequestParam("name") String userName,@RequestParam(name="country") String country,@RequestParam(name="email") String email,@RequestParam(name="age") int age){
		User user = new User(userName, age, email, country);// apply validation here
		ModelAndView modelAndView = new ModelAndView("registerSuccess");
		modelAndView.addObject("user", user);
		
		return modelAndView;
	}
	
	//used map for fetching form values --  <mvc:annotation-driven></mvc:annotation-driven> must be der in .xml file
	@RequestMapping(value="/registerSuccessViaMap",method=RequestMethod.POST)
	public ModelAndView requestParamMap(@RequestParam HashMap<String,String> requestMap){
		User user = new User(requestMap.get("name"),Integer.parseInt(requestMap.get("age")),requestMap.get("email"),requestMap.get("country"));
		ModelAndView modelAndView = new ModelAndView("registerSuccess");
		modelAndView.addObject("user", user);
		
		return modelAndView;
	}
	
	//Use Case :: return path from the action pass to other action
	//@RequestParam is used to resolve issue  
	//"redirect:/"+Path) --  used to redirect to other controller method
	@RequestMapping(value="/registerSuccessPath/",method=RequestMethod.POST)
	public ModelAndView registerSuccessPath(@RequestParam("name") String name,@RequestParam("country") String country,@RequestParam("email") String email,@RequestParam("age") int age){
		String Path = "/registerSuccess1/"+name+"/"+email+"/"+age+"/"+country+"/";
		logger.info("Rediect to Path "+Path);
		ModelAndView modelAndView = new ModelAndView("redirect:/"+Path);
		return modelAndView; 
	}
	
	@RequestMapping(value="/registerSuccess1/{name}/{email}/{age}/{country}/",method=RequestMethod.GET)
	public ModelAndView registerSuccess1(@PathVariable("name") String name,@PathVariable("country") String country,@PathVariable("email") String email,@PathVariable("age") int age){
		User user = new User(name, age, email, country);
		ModelAndView modelAndView = new ModelAndView("registerSuccess1","user", user);		
		return modelAndView;		
	}
	
	@RequestMapping(value="/welcomeAgain",method=RequestMethod.GET)
	public ModelAndView welcomeAgain(){
		ModelAndView modelAndView = new ModelAndView("welcome","welcomeMsg",welcomeService.welcomeAgain());
		
		return modelAndView;
		
	}
	@RequestMapping(value="/welcomeMayuri",method=RequestMethod.GET)
	public ModelAndView welcomeMayuri(){
		ModelAndView modelAndView = new ModelAndView("welcome","welcomeMsg",welcomeService.welcome());
		
		return modelAndView;
		
	}
	
	
	
}