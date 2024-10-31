package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.City;
import com.example.demo.model.CityRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class CityController {
	
	@Autowired
	CityRepository cityRepo;
	
	// Get all cities
    @GetMapping("/cities")
    public List<City> getAllCities() {
        return cityRepo.findAll();
    }

    // Get city by id
    @GetMapping("/cities/{id}")
    public ResponseEntity<City> getCityById(@PathVariable Long id) {
        City city = cityRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("City not found with id: " + id));
        return ResponseEntity.ok(city);
    }

    // Create new city
    @PostMapping("/cities")
    public City createCity(@RequestBody City city) {
        return cityRepo.save(city);
    }

    // Update city
    @PutMapping("/cities/{id}")
    public ResponseEntity<City> updateCity(@PathVariable Long id, @RequestBody City cityDetails) {
        City city = cityRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("City not found with id: " + id));
        
        city.setName(cityDetails.getName());
        city.setParks(cityDetails.getParks());
        
        City updatedCity = cityRepo.save(city);
        return ResponseEntity.ok(updatedCity);
    }

    // Delete all cities
    @DeleteMapping("/cities")
    public ResponseEntity<Void> deleteAllCities() {
        cityRepo.deleteAll();
        return ResponseEntity.ok().build();
    }

    // Delete city by id
    @DeleteMapping("/cities/{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable Long id) {
        cityRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
