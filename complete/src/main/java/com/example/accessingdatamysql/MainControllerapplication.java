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


import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;
import java.util.HashMap;
import java.util.Map;
import java.util.List;


@Controller	// This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class MainControllerapplication extends MainController {
	@Autowired // This means to get the bean called userRepository
			   // Which is auto-generated by Spring, we will use it to handle the data
	private UserService userservice;

	@GetMapping(path="/users")
	public @ResponseBody List<DTOuser> getAllUsers() {
		return userservice.returnAllusers();
	}
	
	
	  @GetMapping("/users/id/{id}")
  	public   @ResponseBody DTOuser getOneUser(@PathVariable Integer id) {
    		return  userservice.findById(id);    
  }
  	
  	@GetMapping("/users/name/{name}")
  	public   @ResponseBody List<DTOuser> getOneUser(@PathVariable String name) {
  		return userservice.returnUserByName(name);
 
  }
  	
 	
 	@DeleteMapping("/users/id/{id}")
 	public @ResponseBody DTOanswer deleteUserById(@PathVariable Integer id){
 		return userservice.deleteUserById(id);
 	}
 	
 	
 	@PostMapping(path = "/users")
	public @ResponseBody DTOanswer addNewUser(@RequestParam String name, @RequestParam String email){
		DTOuser n = new DTOuser();
		n.setName(name);
		n.setEmail(email);
		return userservice.saveUser(n); 
	}
	@PostMapping("/users/object")
	public @ResponseBody DTOanswer createUser(@RequestBody DTOuser u) {
		return userservice.saveUser(u); 		
 		
	}
	
	@PutMapping(path = "/users/id/{id}")
	public @ResponseBody DTOanswer editUserById(@PathVariable Integer id, @RequestParam String name, @RequestParam String email){
		DTOuser n = userservice.findById(id);
		n.setName(name);
		n.setEmail(email);
		return userservice.saveUser(n); 
	}
	
	
	@PutMapping(path = "/users/object/id/{id}")
	public @ResponseBody DTOanswer editUserById(@PathVariable Integer id, @RequestBody DTOuser u){
		DTOuser n = userservice.findById(id);
		n.setName(u.getName());
		n.setEmail(u.getEmail());
		return userservice.saveUser(n); 
	}
	
}
