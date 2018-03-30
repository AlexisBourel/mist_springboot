package co.simplon.springboot.simplecrud.controller;

import javax.validation.Valid;

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

import co.simplon.springboot.simplecrud.model.Vehicule;
import co.simplon.springboot.simplecrud.repository.VehiculeRepository;

@RestController
@RequestMapping("/api")
public class VehiculeController {
	@Autowired
	VehiculeRepository repository;
	
	@CrossOrigin
	@GetMapping("/vehicule/{id}")
	ResponseEntity<Vehicule> getVehiculeById(@PathVariable(value="id") int id) {
		Vehicule vehicule = repository.findOne(id);
		if(vehicule == null) {
			return ResponseEntity.notFound().build();
	}
		return ResponseEntity.ok().body(vehicule);
	}
	
	@CrossOrigin
	@PostMapping("/vehicule")
	Vehicule addVehicule(@Valid @RequestBody Vehicule vehicule) {
		return repository.save(vehicule);
	}
	
	@CrossOrigin
	@PutMapping("/vehicule/{id}")
	ResponseEntity<Vehicule> UpdateVehicule(@PathVariable(value="id") int id, @Valid @RequestBody Vehicule vehicule) {
		Vehicule vehiculeToUpdate = repository.findOne(id);
		if(vehiculeToUpdate == null) {
			return ResponseEntity.notFound().build();
		}
		Vehicule updateVehicule = repository.save(vehiculeToUpdate);
		return ResponseEntity.ok(updateVehicule);
	}
	
	@CrossOrigin
	@DeleteMapping("vehicule/{id}")
	ResponseEntity<Vehicule> deleteVehicule(@PathVariable(value="id") int id){
		Vehicule vehicule = repository.findOne(id);
		if(vehicule == null) {
			return ResponseEntity.notFound().build();
		}
		
		repository.delete(vehicule);
		return ResponseEntity.ok().build();
		}

}
