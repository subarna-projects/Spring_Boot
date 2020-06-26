package com.example.demo.service;



import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.UserRepository;
import com.example.demo.model.UserBean;
@Transactional
@Service
public class UserService {
	@Autowired
	private UserRepository urepository;
	public UserBean saveUser(UserBean user)
	{
		return urepository.save(user);
	
	}
	public Optional<UserBean> findUser(int id) {
		// TODO Auto-generated method stub
		
		if( urepository.findById(id) != null)
			return urepository.findById(id);
		else
			return null;
	}
	public ArrayList<UserBean> viewUsers() {
		// TODO Auto-generated method stub
		return (ArrayList<UserBean>) urepository.findAll();
	}
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		urepository.deleteById(id);
		
	}
	

}
