package co.id.jasaraharja.microservices.auth.token;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import co.id.jasaraharja.microservices.auth.domain.User;
import co.id.jasaraharja.microservices.auth.service.UserService;

@Configuration
public class JRTokenEnhancer implements TokenEnhancer {

	@Autowired
	private UserService userService;
	
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		UserDetails user = (UserDetails) authentication.getPrincipal();
		final Map<String, Object> additionalInfo = new HashMap<>();
		
		additionalInfo.put("authorities", user.getAuthorities());
		additionalInfo.put("username", user.getUsername());
		
		// get user profile
		User userProfile = userService.findUser(user.getUsername());
		
		if (userProfile != null) {
			additionalInfo.put("email", userProfile.getEmail());
			additionalInfo.put("roles", userProfile.getRole());
			additionalInfo.put("full_name", userProfile.getFullName());
			additionalInfo.put("mobile_no", userProfile.getPhone());
		}
		
		((DefaultOAuth2AccessToken) accessToken)
				.setAdditionalInformation(additionalInfo);
		
		return accessToken;
	}

}
