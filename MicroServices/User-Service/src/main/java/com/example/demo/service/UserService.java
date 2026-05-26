package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Hotel;
import com.example.demo.entity.Rating;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	RestTemplate restTemplate;
	
	public User createUser(User user)
	{
		return userRepo.save(user);
		
	}
	
	public List<User>getAllUser()
	
	{
		List<User> userList = userRepo.findAll();
		List<User>newUserList=new ArrayList<>();
		for(User u:userList)
		{
			Rating[] ratArr= restTemplate.getForObject("http://RATING-SERVICE/rating/getAllRatingByUserId/"+u.getUserId(),Rating[].class);

			List<Rating>ratList=Arrays.stream(ratArr).toList();
			
			List<Rating> newRating=new ArrayList<>();
			for(Rating r:ratList)
			{
				Hotel h=restTemplate.getForObject("http://HOTEL-SERVICE/hotel/getHotelById/"+r.getHotelId(),Hotel.class);

				r.setHotel(h);
				newRating.add(r);
			}
			u.setRating(newRating);
			newUserList.add(u);
		}
		return newUserList;
		
	}

	public User getUserById(int userId)
	{
		User u=userRepo.findById(userId).get();

		Rating[] ratingArr= restTemplate.getForObject("http://RATING-SERVICE/rating/getAllRatingByUserId/"+userId,Rating[].class);
		
		
		ArrayList<Rating> rList=new ArrayList<>();
		
		for(Rating r:ratingArr)
		{
			Hotel h=restTemplate.getForObject("http://HOTEL-SERVICE/hotel/getHotelById/"+r.getHotelId(),Hotel.class);
		    r.setHotel(h);
		    rList.add(r);
		}
		
		u.setRating(rList);
		
		return u;
		
	}
	
	
}
