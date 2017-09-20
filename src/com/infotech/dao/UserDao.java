package com.infotech.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.infotech.model.User;

@Repository
public class UserDao {
	
	Logger logger = Logger.getLogger("com.infotech.dao.UserDao");
	
	@Autowired
	private JdbcTemplate jdbcTemplate;  
	  
	
	private static List<User> userList = null;	// declaration
	
	
	static
	{	
		userList = new ArrayList<User>(); //initialization
		userList.add(new User("mayuri",27,"a@gmail.com","India"));
		userList.add(new User("mayuri1",27,"a@gmail.com","India"));
		userList.add(new User("mayuri2",27,"a@gmail.com","India"));
		userList.add(new User("mayuri3",27,"a@gmail.com","India"));
	}
	
	public  List<User> getUserList() {
		return userList;
	}
	
	
	public void saveIntoMyUser(User user)
	{
		logger.info("SaveIntoMyUser");
		
		String name = user.getName();
		int age =user.getAge();
		String email =user.getEmail();
		String country =user.getCountry();
		String insertSql = "insert into MyUser values('"+name+"',"+ age +",'"+ email +"','"+ country+"')";
		
		logger.info("row inserted in table "+jdbcTemplate.update(insertSql));
		
		
	}
}