package com.cg.FirstScbUserServices.externalservices;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cg.FirstScbUserServices.entities.Ratings;

//RatingService.java
@FeignClient(name = "RATING-SERVICE")
public interface RatingService {
	@GetMapping("/ratings/{userId}")
	List<Ratings> getRatingsByUserId(@PathVariable("userId") Long userId);
}
