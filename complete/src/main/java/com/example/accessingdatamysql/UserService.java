package com.example.accessingdatamysql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

@Service
public class UserService {
   @Autowired
  private UserRepository userRepository;
  
  public Iterable<User> findAllUsers(){
		return userRepository.findAll();
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
   
}
