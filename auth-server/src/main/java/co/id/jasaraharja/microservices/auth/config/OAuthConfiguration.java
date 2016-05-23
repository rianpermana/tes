package co.id.jasaraharja.microservices.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import co.id.jasaraharja.microservices.auth.token.JRTokenEnhancer;

@Configuration
@EnableAuthorizationServer
public class OAuthConfiguration extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private AuthenticationManager auth;
	
	@Autowired
	private JRTokenEnhancer jrTokenEnhancer;


	/**
	 * We set our authorization storage feature specifying that we would use the
	 * JDBC store for token and authorization code storage.<br>
	 * <br>
	 * 
	 * We also attach the {@link AuthenticationManager} so that password grants
	 * can be processed.
	 */
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints)
			throws Exception {
		endpoints.authenticationManager(auth)
			.approvalStoreDisabled()
			.tokenEnhancer(jrTokenEnhancer);
	}

	/**
	 * Setup the client application which attempts to get access to user's
	 * account after user permission.
	 */
	@Override
	public void configure(ClientDetailsServiceConfigurer clients)
			throws Exception {
		clients.inMemory()
			.withClient("client")
			.authorizedGrantTypes("authorization_code", "client_credentials", 
					"refresh_token","password", "implicit")
			.authorities("ROLE_CLIENT")
			.resourceIds("apis")
			.scopes("read")
			.scopes("write")
			.secret("secret")
			.accessTokenValiditySeconds(300);
	}
	
	/**
	 * Configure the {@link AuthenticationManagerBuilder} with initial
	 * configuration to setup users.
	 * 
	 * @author anilallewar
	 *
	 */
	@Configuration
	@Order(Ordered.LOWEST_PRECEDENCE - 20)
	protected static class AuthenticationManagerConfiguration extends
			GlobalAuthenticationConfigurerAdapter {


		@Autowired
		private LdapSettings ldapSettings;
		
		/**
		 * Setup 2 users with different roles
		 */
		@Override
		public void init(AuthenticationManagerBuilder auth) throws Exception {
			auth.ldapAuthentication()
			.contextSource()
				.url(ldapSettings.getUrl())
				.managerDn(ldapSettings.getManagerDn())
				.managerPassword(ldapSettings.getManagerPassword())
			.and()
				.userSearchBase(ldapSettings.getUserSearchBase())
				.userSearchFilter(ldapSettings.getUserSearchFilter())
				.groupSearchBase(ldapSettings.getGroupSearchBase())
				.groupSearchFilter(ldapSettings.getGroupSearchFilter());
		}
	}	
}
