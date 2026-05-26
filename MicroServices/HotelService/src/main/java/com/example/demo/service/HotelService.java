package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Hotel;
import com.example.demo.repository.HotelRepo;

@Service
public class HotelService {
	
	@Autowired
	private HotelRepo hotelRepo;
	
	public Hotel addHotel(Hotel hotel)
	{
		return hotelRepo.save(hotel);
	}
	
	public List<Hotel>getAllHotel()
	{
		return hotelRepo.findAll();
	}
	
	public Hotel getHotelById(int hotelId)
	{
		return hotelRepo.findById(hotelId).get();
	}
	
	

}
