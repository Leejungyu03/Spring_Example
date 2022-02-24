package com.example.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.dao.UserDAO;
import com.example.lesson04.model.User;

@Service
public class UserBO {
	
	@Autowired
	private UserDAO newUserDAO;
	
	public void addUser(String name, String yyyymmdd, String introduce, String email) {
		newUserDAO.insertUser(name, yyyymmdd, introduce, email);
	}
	
	public User getLastUser() {
		return newUserDAO.selectLastUser();
	}
}