package com.infotech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.infotech.dao.UserDao;
import com.infotech.model.User;


@Controller
public class UserListService {
	
	@Autowired
	private UserDao userDao ;
	
	public List<User> getUserList()
	{
		return userDao.getUserList();
	}
	
}
