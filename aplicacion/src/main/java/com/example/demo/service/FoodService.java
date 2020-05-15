package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Food;

@Service
public interface FoodService {
	public Iterable<Food> getAllFoods();
	public Food crearUsuario(Food Food) throws Exception;
}
