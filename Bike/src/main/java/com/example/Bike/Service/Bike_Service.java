package com.example.Bike.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Bike.Entity.Bike;
import com.example.Bike.repositry.Bike_Repositry;

@Service
public class Bike_Service {
	
	@Autowired
	private Bike_Repositry repositry;
	
	public Bike addbike(Bike bike)
	{
		return repositry.save(bike);
	}
	
	public List<Bike> getall()
	{
		return repositry.findAll();
	}
	
	public Bike getbyid(Long id)
	{
		return repositry.findById(id).orElse(null);
	}
	
	public void delete(Long id)
	{
		repositry.deleteById(id);
	}
	

}
