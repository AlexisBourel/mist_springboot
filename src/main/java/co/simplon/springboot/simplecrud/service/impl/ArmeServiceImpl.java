package co.simplon.springboot.simplecrud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.springboot.simplecrud.model.Arme;
import co.simplon.springboot.simplecrud.repository.ArmeRepository;
import co.simplon.springboot.simplecrud.service.ArmeService;

@Service
public class ArmeServiceImpl implements ArmeService{

	@Autowired
	private ArmeRepository armeRepository;
		
	public List<Arme> getAllArmes(){
		return this.armeRepository.findAll();
	}
	
	public void deleteArme(Arme utilisateur) {
		this.armeRepository.delete(utilisateur);
	}
	
	public Arme getArme(Long id) {
		return this.armeRepository.findOne(id);
	}

	@Override
	public Arme addArme(Arme arme) {
		return this.armeRepository.save(arme);
	}
}