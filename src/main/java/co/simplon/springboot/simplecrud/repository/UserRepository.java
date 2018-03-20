package co.simplon.springboot.simplecrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.springboot.simplecrud.model.Utilisateur;

public interface UserRepository extends JpaRepository<Utilisateur, Long> {

}
