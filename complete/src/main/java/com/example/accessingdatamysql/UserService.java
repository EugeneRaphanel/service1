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
  
  
	private Iterable<User> findAllUsers(){
		return userRepository.findAll();
		
	}
	public DTOuser findById(Integer id){
		Optional<User> u =  userRepository.findById(id);
    	return u.get().daoToDto(); // Exception not handle
	}
	private List<User> findByNameIgnoreCase(String name){
		return userRepository.findByNameIgnoreCase(name);
	}
	
	private List<DTOuser> iterabletoDTOuser(Iterable<User> iterable) {
		Iterator<User> it = iterable.iterator();
		List<DTOuser> result = new ArrayList<DTOuser>();
		DTOuser u ;
    		while(it.hasNext()){
    			u = it.next().daoToDto();
    			result.add(u);
    		}
    		return result;
	}
	
	public List<DTOuser> returnAllusers(){
		Iterable<User> iterable = this.findAllUsers();
		return iterabletoDTOuser(iterable);
		}
		
	public List<DTOuser> returnUserByName(String name){
		Iterable<User> iterable = this.findByNameIgnoreCase(name);
		return iterabletoDTOuser(iterable);
	
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
