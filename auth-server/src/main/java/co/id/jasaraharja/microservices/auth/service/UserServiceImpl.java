package co.id.jasaraharja.microservices.auth.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.id.jasaraharja.microservices.auth.domain.User;

@Component("userService")
public class UserServiceImpl implements UserService {
	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
    private UserRepository userRepository;

	public User findUser(String username) {
		logger.debug("findUser():username={}", username);
		return userRepository.findOne(username);
	}

	@Override
	public User savePushToken(String username, String pushToken) {
		User updatedUser = null;
		logger.debug("savePushToken():username={}|pushToken={}", username, pushToken);
		User user = userRepository.findOne(username);
		if (user != null) {
			user.setPushToken(pushToken);
			updatedUser = userRepository.save(user);
		}
		
		return updatedUser;
	}
	
	
}
