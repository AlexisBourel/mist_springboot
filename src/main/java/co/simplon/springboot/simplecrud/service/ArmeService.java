package co.simplon.springboot.simplecrud.service;

import java.util.List;

import org.springframework.stereotype.Service;

import co.simplon.springboot.simplecrud.model.Arme;


@Service
public interface ArmeService {

	List<Arme> getAllArmes();
	void deleteArme(Arme arme);
	Arme getArme(Long id);
	Arme addArme(Arme arme);
	
}
