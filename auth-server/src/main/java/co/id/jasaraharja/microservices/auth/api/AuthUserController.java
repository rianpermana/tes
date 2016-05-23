package co.id.jasaraharja.microservices.auth.api;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.id.jasaraharja.microservices.auth.domain.User;
import co.id.jasaraharja.microservices.auth.service.UserService;

@RestController
@RequestMapping("/")
public class AuthUserController {
	Logger logger = LoggerFactory.getLogger(AuthUserController.class);
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/me", method = RequestMethod.GET)
	public Principal getCurrentLoggedInUser(Principal user) {
		return user;
	}
	
	@RequestMapping(value = "/register-token/{pushToken}", method = RequestMethod.POST)
	public @ResponseBody User registerPushToken(@PathVariable String pushToken,
			OAuth2Authentication authentication) {
		UserDetails user = (UserDetails) authentication.getPrincipal();
		String username = user.getUsername();
		logger.debug("registerPushToken():username={}|pushToken={}", username, pushToken);
		return userService.savePushToken(username, pushToken);
	}
}
