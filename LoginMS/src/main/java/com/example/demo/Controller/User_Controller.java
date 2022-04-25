package com.example.demo.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Exception.Invalid_Credentials;
import com.example.demo.Model.Login;
import com.example.demo.Model.Users;
import com.example.demo.Service.User_Service;

@RestController
@RequestMapping("/Login")
public class User_Controller {
	@Autowired
	private User_Service userService;
	Users useDetails=new Users();
	
	
	
	@GetMapping("/ById")
	public String login(@RequestBody Login login) throws Invalid_Credentials{
		String password="";
		String Id=login.getId();
		String Pass=login.getPassword();
		if(Id.isBlank())
		{
			throw new Invalid_Credentials("Invalid UserName");
		}
		else {
			if(Pass.isBlank()) {
				throw new Invalid_Credentials("Invalid Password");
			}
			
			else {
				Optional<Users> user=userService.findByUserId(Id);
				if(user.isPresent()) {
				    useDetails=user.get();
					password =useDetails.getPassword();
						if(!password.equals(Pass)) {
							throw new Invalid_Credentials("Please place correct Password");
						}
					
				}
				
				else {
					throw new Invalid_Credentials("UserName not Present");
					//return useDetails.toString();
				}
			}
			
				
				
		}
			
	//	System.out.println(Id+"Login Successfull"+Pass+useDetails.toString());
		return  "Login Successfull";
		
	}
}
