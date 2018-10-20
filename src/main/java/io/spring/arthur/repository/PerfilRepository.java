package io.spring.arthur.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.spring.arthur.entity.Perfil;


public interface PerfilRepository extends MongoRepository<Perfil, String> {

    Perfil findByNome(String role_admin);

}
