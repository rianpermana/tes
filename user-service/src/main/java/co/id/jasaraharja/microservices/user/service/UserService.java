package co.id.jasaraharja.microservices.user.service;

import java.util.List;

import co.id.jasaraharja.microservices.user.domain.User;

public interface UserService {
	List<User> findAllUser();
	User findUser(String username);
	User createUser(User user);
	void deleteUser(String username);
}
