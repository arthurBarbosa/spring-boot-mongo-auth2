package io.spring.arthur.config;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import io.spring.arthur.entity.Perfil;
import io.spring.arthur.entity.Usuario;
import io.spring.arthur.repository.PerfilRepository;
import io.spring.arthur.repository.UsuarioRepository;

@Component
public class CargaInicial implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	PerfilRepository perfilRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent e) {
		List<Perfil> perfis = perfilRepository.findAll();

		if (perfis.isEmpty()) {
			perfilRepository.save(new Perfil("ROLE_ADMIN"));

			Perfil perfil = perfilRepository.findByNome("ROLE_ADMIN");

			List<Perfil> perfisUsuario = new ArrayList<>();

			perfisUsuario.add(perfil);

			usuarioRepository.save(new Usuario("Arthur", perfisUsuario, "admin", "123"));
		}
	}

}
