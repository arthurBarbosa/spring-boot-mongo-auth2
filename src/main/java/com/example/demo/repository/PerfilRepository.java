package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entity.Perfil;
import com.example.demo.entity.Usuario;

public interface PerfilRepository  extends MongoRepository<Perfil, String>{
	
	List<Perfil> findByNomeLikeIgnoreCase(String nome);

}
