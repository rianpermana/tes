package co.id.jasaraharja.microservices.auth.service;

import co.id.jasaraharja.microservices.auth.domain.User;

public interface UserService {
	User findUser(String username);
	User savePushToken(String username, String pushToken);
}
