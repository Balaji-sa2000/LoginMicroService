package com.example.demo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.Model.Users;
import com.example.demo.Repo.User_Repo;
import com.example.demo.Service.User_Service;


@SpringBootTest
public class LoginTest {
	@SpringBootTest
	class BookTest {
		
		@MockBean
		private User_Repo repo;
		@Autowired
		private User_Service service;
		@Test
		public void Login() {
			Users user=new Users();
			user.setApplyType("PASSPORT");
			user.setCitizenship("Teen");
			user.setContact(7660833423L); 
			user.setDateOfBirth(LocalDate.parse("2004-04-05"));
			user.setEmailId("balaji2000@gmail.com");
			user.setGender("Male");
			user.setHintAnswer("balu");
			user.setHintQuestion("What is your name");
			user.setName("S A Balaji");
			user.setPassword("Balaji2000@");
			user.setQualification("Graduate");
			user.setUserId("PASS-1234");
			
			when(repo.findById(user.getUserId()).get()).thenReturn(user);
			assertEquals(user,service.findByUserId("PASS-1234").get());
		}
		
}
}
