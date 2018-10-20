package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Usuario;
import com.example.demo.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<Usuario> listaUsuario() {
		return usuarioRepository.findAll();
	}

	public Usuario salvarUsuario(Usuario usuarioAdd) {

		return usuarioRepository.save(usuarioAdd);
	}

	public void deletarUsuario(String id) {
		usuarioRepository.deleteById(id);
	}

	public Optional<Usuario> consultarUsuario(String id) {
		return usuarioRepository.findById(id);
	}
	
	public List<Usuario> buscarPorNome(String nome){
		return usuarioRepository.findByNomeLikeIgnoreCase(nome);
		
	}
}
