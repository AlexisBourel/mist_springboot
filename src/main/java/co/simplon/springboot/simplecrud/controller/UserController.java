package co.simplon.springboot.simplecrud.controller;

import java.util.List;

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

import co.simplon.springboot.simplecrud.model.Utilisateur;
import co.simplon.springboot.simplecrud.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	UserRepository repository;
	
	@CrossOrigin
	@GetMapping("/user")
	List<Utilisateur> getAllUser(){
		return repository.findAll();
	}
	
	@CrossOrigin
	@GetMapping("/peo/{id}")
	ResponseEntity<Utilisateur> getUserById(@PathVariable(value="id") long id) {
	    Utilisateur user = repository.findOne(id);
	    if(user == null) {
	        return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.ok().body(user);
	}
	
	@CrossOrigin
	@PostMapping("/user")
	Utilisateur addUser(@Valid @RequestBody Utilisateur user){
		return repository.save(user);
	}
	
	@CrossOrigin
	@PutMapping("/user/{id}")
	ResponseEntity<Utilisateur> updateUser(@PathVariable(value="id") long id, @Valid @RequestBody Utilisateur user){
		Utilisateur userToUpdate = repository.findOne(id);
		if(userToUpdate == null)
			return ResponseEntity.notFound().build();
		
		// Update the mandatory attributes
		userToUpdate.setPrenom(user.getPrenom());
		userToUpdate.setNom(user.getNom());
		
		// Update all other not null attributes
		
		if(user.getEmail() != null)
			userToUpdate.setEmail(user.getEmail());
		
		Utilisateur updateduser = repository.save(userToUpdate);
		return ResponseEntity.ok(updateduser);
	}
	
	@CrossOrigin
	@DeleteMapping("/user/{id}")
	ResponseEntity<Utilisateur> deleteUser(@PathVariable(value="id") long id){
		Utilisateur user = repository.findOne(id);
		if(user == null)
			return ResponseEntity.notFound().build();
		
		repository.delete(user);
		return ResponseEntity.ok().build();
	}
}
