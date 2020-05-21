package com.example.demo.service;

//no me reconoce esta libreria org.modelmapper;
import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Service;
import com.example.demo.common.dto.request.FoodRegistraticonDto;
import com.example.demo.common.dto.response.FoodResponseDto;
import com.example.demo.entity.Food;
import com.example.demo.repository.FoodRepository;

import antlr.collections.List;
import ch.qos.logback.classic.Logger;
import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@Service
public class FoodService {
	
	
	private FoodRepository userRepository;
	private ModelMapper modelMapper;
	
	
	public FoodService(FoodRepository userRepository, ModelMapper modelMapper) {
		
		this.userRepository = userRepository;
		this.modelMapper = modelMapper;
	}
	

	
	/**
	 * It saves a new user to the database
	 * @param user to be stored
	 * @return User stored in the DB.
	 */
	public FoodResponseDto save(FoodRegistraticonDto userDto) {
		Food converted = modelMapper.map(userDto, Food.class);

        Food persistedUser = userRepository.save(converted);
        FoodResponseDto userResponse = modelMapper.map(persistedUser, FoodResponseDto.class);
        
        return userResponse;
	}
	
	/**
	 * It removes a specified user from DB.
	 * @param userId the user identifier
	 */
	public void delete(Long userId) {
		userRepository.deleteById(userId);
	}
}
