package com.example.accessingdatamysql;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public abstract class MainController {
	public abstract @ResponseBody List<DTOuser> getAllUsers();
	public abstract @ResponseBody DTOuser getOneUser(@PathVariable Integer id);
	public abstract @ResponseBody List<DTOuser> getOneUser(@PathVariable String name);
	public abstract @ResponseBody DTOanswer deleteUserById(@PathVariable Integer id);
	public abstract @ResponseBody DTOanswer addNewUser(@RequestParam String name, @RequestParam String email);
	public abstract @ResponseBody DTOanswer createUser(@RequestBody DTOuser u);
	public abstract @ResponseBody DTOanswer editUserById(@PathVariable Integer id, @RequestParam String name, @RequestParam String email);
	public abstract @ResponseBody DTOanswer editUserById(@PathVariable Integer id, @RequestBody DTOuser u);
}
