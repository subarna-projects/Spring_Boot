package com.example.demo.controller;

import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.UserBean;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/demo")
public class demoController {
	@Autowired
private UserService uservice;

	@GetMapping("/users/{id}")
public Optional<UserBean> viewUser(@PathVariable int id ) 
{
		Optional<UserBean> ret=uservice.findUser(id);
		
	if(!ret.isPresent())
	{
		System.out.println("Exception");
		throw  new UserNotFoundException(id +" not found");
	}
	return ret;
}
	@GetMapping("/users")
	public ArrayList<UserBean> viewUsers( ) 
	{
		return uservice.viewUsers();	
	}
	@PostMapping("/users")
public ResponseEntity<Object> saveUser(@Valid @RequestBody UserBean user) {
	UserBean ret=uservice.saveUser(user);
	int id=ret.getId();
	System.out.println("Inserted");
	URI location= ServletUriComponentsBuilder
			.fromCurrentRequest().path("/{id}").
			buildAndExpand(id).toUri();
	return ResponseEntity.created(location).build();
	
	
}
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		uservice.deleteById(id);
	}
	/*@GetMapping("/usersFilter/{id}")
	public  MappingJacksonValue viewUsersFilter(@PathVariable int id ) 
	{
		SimpleBeanPropertyFilter filter= SimpleBeanPropertyFilter.filterOutAllExcept("cardinfo");
		FilterProvider filters=new SimpleFilterProvider().addFilter("userfilter", filter);
		Optional<UserBean> user=uservice.findUser(id);
		MappingJacksonValue mapping = new MappingJacksonValue(user);
		mapping.setFilters(filters);
		return mapping;
	}*/
	
}
