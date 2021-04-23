package com.example.accessingdatamysql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import java.util.Optional;
@Service
public class UserService {
   @Autowired
  private UserRepository userRepository;
  
  
	public Iterable<User> findAllUsers(){
		return userRepository.findAll();
	}
	public Optional<User> findById(Integer id){
		return userRepository.findById(id);
	}
	public List<User> findByNameIgnoreCase(String name){
		return userRepository.findByNameIgnoreCase(name);
	}
	
	public List<DTOuser> returnAllusers(Iterable<User> iterable){
		Iterator<User> it = iterable.iterator();
		List<DTOuser> result = new ArrayList<DTOuser>();
		DTOuser u ;
    		while(it.hasNext()){
    			u = it.next().daoToDto();
    			result.add(u);
    		}
    		return result;
	}
	
	public DTOanswer deleteUserById(Integer id) {
		DTOanswer response = new DTOanswer();
 		try{
 		userRepository.deleteById(id);
 		}
 		catch( Exception ResourceNotFoundException){
 			response.setSucess(false);
 			return response;
 		}
 		response.setSucess(true);
 		return response;
	
	}
	
	public DTOanswer saveUser(DTOuser u){
		DTOanswer response = new DTOanswer();
		try {
			userRepository.save(u.dtoToDao());
		}
		catch (Exception IllegalArgumentException){
			response.setSucess(false);
 			return response;
		}
		response.setSucess(true);
 		return response;
	}
   
}
