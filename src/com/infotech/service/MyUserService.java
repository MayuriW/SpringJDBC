package com.infotech.service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infotech.dao.UserDao;
import com.infotech.model.User;

@Service
public class MyUserService {
	
	Logger logger = Logger.getLogger("com.infotech.dao.MyUserService");
	
	@Autowired
	private UserDao userDao ;
	
	public void  saveIntoMyUser(User user)
	{
		logger.info(user.getName());
		logger.info(user.getEmail());
		logger.info(" age is "+user.getAge());
		logger.info(" country is "+user.getCountry());
		
		 userDao.saveIntoMyUser(user);
	}

}
