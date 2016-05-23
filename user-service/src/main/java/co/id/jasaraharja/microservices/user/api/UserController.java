package co.id.jasaraharja.microservices.user.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.id.jasaraharja.microservices.user.domain.User;
import co.id.jasaraharja.microservices.user.service.UserService;

@RestController
@RequestMapping("/")
public class UserController {

	Logger logger = LoggerFactory.getLogger(UserController.class);
	
    @Autowired
    private UserService userService;
    
	@RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json")
	public List<User> getAllUsers(OAuth2Authentication authentication) {
		logger.debug("UserController:getAllUsers()");
		return userService.findAllUser();
	}
	
	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
	public User createUser(@RequestBody User user,
			OAuth2Authentication authentication) {
		logger.debug("UserController:createUser() - User = {}", user.toString());
		return userService.createUser(user);
	}
	
	@RequestMapping(value = "/{username:.+}", method = RequestMethod.GET)
	public User findUser(@PathVariable String username,
			OAuth2Authentication authentication) {
		logger.debug("UserController:findUser() - username = {}", username);
		return userService.findUser(username);
	}
	
	@RequestMapping(value = "/{username:.+}", method = RequestMethod.DELETE)
	public User deleteUser(@PathVariable String username,
			OAuth2Authentication authentication) {
		logger.debug("UserController:deleteUser() - username = {}", username);
		userService.deleteUser(username);
		return new User();
	}
}
