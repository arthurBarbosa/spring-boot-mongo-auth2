package io.spring.arthur.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.spring.arthur.config.MyUserDetails;
import io.spring.arthur.entity.Usuario;
import io.spring.arthur.repository.UsuarioRepository;

 
@Service
public class MyUserDetailService implements UserDetailsService{
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(username);
        
        if(usuario == null){
            throw new UsernameNotFoundException("Usuaŕio ou senha inválidos");
        }
        
        return new MyUserDetails(usuario);
        
    }
    
}
