package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.config.MyUserDetails;
import com.example.demo.entity.Usuario;
import com.example.demo.repository.UsuarioRepository;

/**
 * 
 * @author Arthur
 *
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByEmail(username);
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuário ou senha inválidos");
		}
		
		return new  MyUserDetails(usuario);
	}

}
