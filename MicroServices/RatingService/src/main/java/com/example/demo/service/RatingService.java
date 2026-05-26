package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Rating;
import com.example.demo.repository.RatingRepo;

@Service
public class RatingService {
	
	@Autowired
	private RatingRepo ratingRepo;
	
	public Rating addRating(Rating rating)
	{
		return ratingRepo.save(rating);
	}
	
	public List<Rating>getAllRating()
	{
		return ratingRepo.findAll();
	}
	
	public Rating getRatingById(int ratingId)
	{
		return ratingRepo.findById(ratingId).get();
	}
	
	
	
	public List<Rating>getAllRatingByUserId(int userId)
	{
		return ratingRepo.findByUserId(userId);
	}

	public List<Rating> getAllRatingByHotelId(int hotelId) {
		return ratingRepo.findByHotelId(hotelId);
	}

}
