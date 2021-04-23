package com.example.accessingdatamysql;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.accessingdatamysql.User;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	List<User> findByNameIgnoreCase(String name);
}
