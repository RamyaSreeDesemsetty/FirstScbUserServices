package com.cg.FirstScbUserServices.externalservices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cg.FirstScbUserServices.entities.Hotel;

@FeignClient(name = "HOTEL-SERVICE")
	public interface HotelService {
	 
		@GetMapping("/hotels/{id}")
		Hotel getHotel(@PathVariable("id") Long hotelId);
	 
	   
	}

