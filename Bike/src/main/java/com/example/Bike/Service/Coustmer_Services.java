package com.example.Bike.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Bike.Entity.Coustmer;
import com.example.Bike.repositry.Coustmer_Repositry;

@Service
public class Coustmer_Services {
	
	@Autowired
	private Coustmer_Repositry repositry;
	
	public List<Coustmer> getll()
	{
		return repositry.findAll();
	}
	
	public Coustmer getbyId(Long id)
	{
		return repositry.findById(id).orElse(null);
	}
	
	public void delete(Long id)
	{
		 repositry.deleteById(id);
	}
	
	public Coustmer addCoustmer(Coustmer coustmer)
	{
		return repositry.save(coustmer);
	}

}
