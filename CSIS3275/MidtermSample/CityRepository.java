package com.example.demo.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
	
	List<City> findByName(String name);
	List<City> findById(long id);
	List<City> findByParks(int parks);
}
