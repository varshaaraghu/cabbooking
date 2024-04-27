package com.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.User;
import com.repo.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public String createUser(User user) {
			System.out.println("Inside User controller");
			int countByEmailAndMobile = userRepository.findByEmailAndMobile(user.getEmail(),user.getMobile());
			int countByEmail = userRepository.findByEmail(user.getEmail());
			int countByMobile = userRepository.findByMobile(user.getMobile());

			if(countByEmailAndMobile != 0) {
				return "User with same email and mobile already exists";
			}
			else if(countByEmail !=0){
				return "User with same email already exists";

			}
			else if(countByMobile !=0){
				return "User with same mobile already exists";

			}
			else {
				userRepository.save(user);
				return "User created";
			}
		}
	
	
	public String signIn(User user) {
		System.out.println("Inside User controller");
		int countByMobile = userRepository.findByMobile(user.getMobile());
		if(countByMobile == 1) {
			String pwd = userRepository.fetchByMobile(user.getMobile());
			System.out.println(pwd);
			System.out.println(user.getPassword());
			
			if(!pwd.equals(user.getPassword())) {
				return "Invorrect Password ";
			}else {
				return "login success";
			}
		}else {
			return "Entered mobile number does not exist";
		}
		
		
	}
}