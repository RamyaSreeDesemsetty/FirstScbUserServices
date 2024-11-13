package com.cg.FirstScbUserServices.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long hotelId;
	private String hname;
	private String location;
	private String about;

	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Hotel(Long hotelId, String hname, String location, String about) {
		super();
		this.hotelId = hotelId;
		this.hname = hname;
		this.location = location;
		this.about = about;
	}

	public Long getHotelId() {
		return hotelId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public String getHname() {
		return hname;
	}

	public void setHname(String hname) {
		this.hname = hname;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", hname=" + hname + ", location=" + location + ", about=" + about + "]";
	}

}

