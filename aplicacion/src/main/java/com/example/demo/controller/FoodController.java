package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.dto.request.FoodRegistraticonDto;
import com.example.demo.common.dto.response.FoodResponseDto;
import com.example.demo.service.FoodService;



@RestController
@RequestMapping("/comida")
public class FoodController {
	
	@Autowired
	private FoodService userService;
	
	@GetMapping
	
	public String comida() {
		
		return "index";
		
	}
	
	@PostMapping
	public ResponseEntity<FoodResponseDto> save(@Valid @RequestBody final FoodRegistraticonDto userDto) {
		FoodResponseDto persistedUser = userService.save(userDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(persistedUser);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id") final Long userId) {
		userService.delete(userId);
		return ResponseEntity.noContent().build();
	}
	
	
}
