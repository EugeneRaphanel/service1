package com.example.accessingdatamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
//import java.util.ArrayList;
//import java.util.Iterator;

@Controller	// This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class MainController {
	@Autowired // This means to get the bean called userRepository
			   // Which is auto-generated by Spring, we will use it to handle the data
	private UserService userservice;

	@GetMapping(path="/users")
	public @ResponseBody List<DTOuser> getAllUsers() {
		Iterable<User> iterable = userservice.findAllUsers();
		return userservice.returnAllusers(iterable);
	}
	
	
	  @GetMapping("/users/id/{id}")
  	public   @ResponseBody DTOuser getOneUser(@PathVariable Integer id) {
    		Optional<User> u =  userservice.findById(id);
    		return u.get().daoToDto(); // Exception not handle
    
  }
  	
  	@GetMapping("/users/name/{name}")
  	public   @ResponseBody List<DTOuser> getOneUser(@PathVariable String name) {
  		return userservice.returnAllusers(userservice.findByNameIgnoreCase(name));
 
  }
  	
 	
 	@DeleteMapping("/users/id/{id}")
 	public @ResponseBody DTOanswer deleteUserById(@PathVariable Integer id){
 		return userservice.deleteUserById(id);
 	}
 	
 	
 	@PostMapping(path = "/users")
	public @ResponseBody DTOanswer addNewUser(@RequestParam String name
			, @RequestParam String email){
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		DTOuser n = new DTOuser();
		n.setName(name);
		n.setEmail(email);
		return userservice.saveUser(n); 
	}
	@PostMapping("/users/object")
	public @ResponseBody DTOanswer createUser(@RequestBody DTOuser u) {
		return userservice.saveUser(u); 		
 		
	}
	/*
	@PutMapping(path = "/users/id/{id}")
	public @ResponseBody User editUserById(@PathVariable Integer id, @RequestParam String name, @RequestParam String email){
		User n = userRepository.findById(id).get();
		n.setName(name);
		n.setEmail(email);
		return userRepository.save(n);
	}
	
	
	@PutMapping(path = "/users/object/id/{id}")
	public @ResponseBody User editUserById(@PathVariable Integer id, @RequestBody User u){
		User n = userRepository.findById(id).get();
		n.setName(u.getName());
		n.setEmail(u.getEmail());
		return userRepository.save(n);
	}
	*/
}
