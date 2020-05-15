package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;

import com.example.demo.entity.Food;

@Controller
public interface FoodRepository extends CrudRepository<Food, Long> {
	Optional<Food> findByNombre(String name);
}
