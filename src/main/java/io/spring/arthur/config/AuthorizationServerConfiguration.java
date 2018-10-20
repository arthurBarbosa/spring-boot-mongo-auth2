
package io.spring.arthur.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

import io.spring.arthur.service.MyUserDetailService;

/**
 *
 * habilita a autorizacao com token
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

	private TokenStore tokenStore = new InMemoryTokenStore(); // para eu dizer aonde vou armazenar o token, aqui eu to
																// guardando na memoria do servidor

	@Autowired
	@Qualifier("authenticationManagerBean") // para dar prioridade a essa instancia
	private AuthenticationManager authenticationManager;

	@Autowired
	private MyUserDetailService userDetailService;

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpointsConfigurer) {
		endpointsConfigurer.tokenStore(this.tokenStore)// que tipo de token vou aceitar
				.authenticationManager(this.authenticationManager).userDetailsService(userDetailService);
	}

	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory().withClient("mobile").authorizedGrantTypes("password", "authorization_code", "refresh_token")
				.scopes("bar", "read", "write").refreshTokenValiditySeconds(20000).accessTokenValiditySeconds(20000)
				.resourceIds("restservice").secret("123");

	}

	@Bean
	@Primary
	public DefaultTokenServices tokenServices() {
		DefaultTokenServices tokenServices = new DefaultTokenServices();

		tokenServices.setSupportRefreshToken(true);
		tokenServices.setTokenStore(tokenStore);
		return tokenServices;
	}

}
