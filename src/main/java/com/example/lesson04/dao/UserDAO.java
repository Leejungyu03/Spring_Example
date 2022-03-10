package com.example.lesson04.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.lesson04.model.User;

@Repository
public interface UserDAO {
	public void insertUser(
			@Param("name") String name, 
			@Param("yyyymmdd") String yyyymmdd, 
			@Param("introduce") String introduce, 
			@Param("email") String email);
	
	public User selectLastUser();
	
	public boolean existUserByName(String name);
}