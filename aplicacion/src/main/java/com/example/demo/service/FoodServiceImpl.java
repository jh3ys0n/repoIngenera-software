package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Food;
import com.example.demo.repository.FoodRepository;

@Component
public class FoodServiceImpl  implements FoodService{

	@Autowired
	FoodRepository repositorio;
	
	@Override
	public Iterable<Food> getAllFoods() {
		return repositorio.findAll();
	}
	
	public boolean validarComida(Food food) throws Exception {
		Optional<Food> foodFound = repositorio.findByNombre(food.getNombre());
		//java.util.Optional<Food> foodFound = repositorio.findByNombre(food.getNombre());
		if (foodFound.isPresent()) {
			throw new Exception("nombre de comida ya registrada");
		}
		return true;
	}
	



	@Override
	public Food crearUsuario(Food food) throws Exception {
		if (validarComida(food)) {
			food = repositorio.save(food);
		}
		return food;
	}

}
