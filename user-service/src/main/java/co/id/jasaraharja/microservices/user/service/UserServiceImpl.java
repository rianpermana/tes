package co.id.jasaraharja.microservices.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.id.jasaraharja.microservices.user.domain.User;

@Component("userService")
public class UserServiceImpl implements UserService {

	@Autowired
    private UserRepository userRepository;
	  
	public List<User> findAllUser() {
		return (List<User>) userRepository.findAll();
	}

	public User createUser(User user) {
		return (User) userRepository.save(user);
	}

	public void deleteUser(String username) {
		userRepository.delete(username);
	}

	public User findUser(String username) {
		return userRepository.findOne(username);
	}
	
	
}
