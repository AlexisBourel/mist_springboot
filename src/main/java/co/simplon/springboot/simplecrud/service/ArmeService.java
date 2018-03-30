package co.simplon.springboot.simplecrud.service;

import java.util.List;

import co.simplon.springboot.simplecrud.model.Arme;

public interface ArmeService {

	List<Arme> getAllArmes();
	void deleteArme(Arme arme);
	Arme getArme(Long id);
	Arme addArme(Arme arme);
	
}
