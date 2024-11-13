package com.cg.FirstScbUserServices.services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cg.FirstScbUserServices.entities.Hotel;
import com.cg.FirstScbUserServices.entities.Ratings;
import com.cg.FirstScbUserServices.entities.User;
import com.cg.FirstScbUserServices.externalservices.HotelService;
import com.cg.FirstScbUserServices.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository; // Assuming UserRepository for data access
	@Autowired
	RestTemplate restTemplate;
	 @Autowired
	    private HotelService hotelService;
	
	@Override
	public User createUser(User user) {

		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
/*
	@Override
	public User getUserById(Long userId) {
		Optional<User> userExists = userRepository.findById(userId);
		return userExists.orElse(null);
	}
	*/

	public User getUser(Long userId) {
		//http://localhost:8051/ratings/users/dc83bfa6-da67-4a7d-90b9-b536f01b9527
		// TODO Auto-generated method stub
		User user = userRepository.findById(userId).orElseThrow(()->new ArithmeticException("User with given id does not exist in the server"));
		 //User user = userRepo.findById(userId).orElseThrow(() -> new ArithmeticException("User with given id is not found on serve"));
	        // fetch rating of the above  user from RATING SERVICE
	        //http://localhost:8083/ratings/users/47e38dac-c7d0-4c40-8582-11d15f185fad
 
			Ratings[] ratingsOfUser = restTemplate
					.getForObject("http://RATING-SERVICE/ratings/users/" + user.getUserId(), Ratings[].class);
	        //logger.info("{} ", ratingsOfUser);
	        List<Ratings> ratings = Arrays.stream(ratingsOfUser).toList();
	        List<Ratings> ratingList = ratings.stream().map(rating -> {
	            //api call to hotel service to get the hotel
	            //http://localhost:8082/hotels/1cbaf36d-0b28-4173-b5ea-f1cb0bc0a791
	            //ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
	            Hotel hotel = hotelService.getHotel(rating.getHotelId());
	            // logger.info("response status code: {} ",forEntity.getStatusCode());
	            //set the hotel to rating
	            rating.setHotel(hotel);
	            //return the rating
	            return rating;
	        }).collect(Collectors.toList());
 
	        user.setRatings(ratingList);
 
	        return user;
 
	       


	}
 
	}

