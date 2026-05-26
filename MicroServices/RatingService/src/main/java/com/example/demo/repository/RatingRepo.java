package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Rating;

public interface RatingRepo extends JpaRepository<Rating, Integer>{


	public List<Rating> findByUserId(int userId);
	
	public List<Rating> findByHotelId(int hotelId);
}
