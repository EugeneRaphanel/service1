package com.example.accessingdatamysql;

import org.springframework.data.repository.CrudRepository;

import com.example.accessingdatamysql.Pizza;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called PizzaRepository
// CRUD refers Create, Read, Update, Delete

public interface PizzaRepository extends CrudRepository<Pizza, Integer> {

	List<Pizza> findByNameIgnoreCase(String name);
}
