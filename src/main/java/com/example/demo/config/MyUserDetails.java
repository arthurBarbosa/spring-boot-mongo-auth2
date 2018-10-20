package com.example.demo.config;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.entity.Usuario;

/**
 * 
 * @author Arthur
 *
 */
public class MyUserDetails extends Usuario implements UserDetails {

	private static final long serialVersionUID = 1L;

	public MyUserDetails(Usuario usuario) {
		super(usuario);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return getPerfis();
	}

	@Override
	public String getPassword() {
		return getSenha();
	}

	@Override
	public String getUsername() {
		return getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
