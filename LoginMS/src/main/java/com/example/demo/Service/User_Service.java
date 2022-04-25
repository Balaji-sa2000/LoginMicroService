package com.example.demo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Users;
import com.example.demo.Repo.User_Repo;

@Service
public class User_Service {

	@Autowired
	private User_Repo repo;
	
	public Optional<Users> findByUserId(String userId) {
		Optional<Users> user=repo.findById(userId);
		return user;
	}
}
