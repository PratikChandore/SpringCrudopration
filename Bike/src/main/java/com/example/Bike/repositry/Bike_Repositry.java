package com.example.Bike.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Bike.Entity.Bike;

public interface Bike_Repositry extends JpaRepository<Bike, Long> {

}
