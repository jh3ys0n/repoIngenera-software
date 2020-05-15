package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Food;
import com.example.demo.repository.FoodRepository;
import com.example.demo.service.FoodService;

@Controller
public class FoodController {

	@Autowired
	FoodService foodeservice;
	@Autowired
	FoodRepository foodrespository;
	@GetMapping("/userForm")
	public String regsitroComida(ModelMap model) {
		model.addAttribute("userForm",new Food());
		return "user-form";
	}
	@PostMapping("/userForm")
	public String saveUser(@Valid @ModelAttribute("user-form.html")Food food,BindingResult result,ModelMap model ) {
		if(result.hasErrors()) {
			model.addAttribute("userForm", food);
			model.addAttribute("listTab","active");
		}
		else {
			try {
				foodeservice.crearUsuario(food);
				model.addAttribute("userForm",new Food());
				model.addAttribute("fromTab","active");
			} catch (Exception e) {
				model.addAttribute("formErrorMessage",e.getMessage());
				model.addAttribute("userForm",food);
				model.addAttribute("fromTab", "active");
			}
		}
		
		return "user-form";
	}	
}
