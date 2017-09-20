package com.infotech.service;

import org.springframework.stereotype.Service;

@Service
public class WelcomeService {
	
	
	
	/*public WelcomeService() {
		super();
	}*/

	public String welcome()
	{
		return "welcome user";
	}
	
	public String welcomeAgain()
	{
		return "welcome again user";
	}

}
