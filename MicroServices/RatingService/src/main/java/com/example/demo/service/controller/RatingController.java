package com.example.demo.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Rating;
import com.example.demo.service.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingController {
	@Autowired
	private RatingService ratingService;

	@PostMapping("/addRating")
	public Rating addRating(@RequestBody Rating rating)
	{
		return ratingService.addRating(rating);	
	}
	
	@GetMapping("/getAllRating")
	public List<Rating>getAllRating()
	{
		return ratingService.getAllRating();
	}
	
	@GetMapping("/getRatingById/{ratingId}")
	public Rating getRatingById(@PathVariable int ratingId)
	{
		return ratingService.getRatingById(ratingId);
	}
	
	
	
	@GetMapping("/getAllRatingByUserId/{userId}")
	public List<Rating>getAllRatingByUserId(@PathVariable int userId)
	{
		return ratingService.getAllRatingByUserId(userId);
	}
	
	@GetMapping("/getAllRatingByHotelId/{hotelId}")
	public List<Rating>getAllRatingByHotelId(@PathVariable int hotelId)
	{
		return ratingService.getAllRatingByHotelId(hotelId);
		
	}
}

