package co.id.jasaraharja.microservices.user.service;


import org.springframework.data.repository.CrudRepository;

import co.id.jasaraharja.microservices.user.domain.User;

public interface UserRepository extends CrudRepository<User, String> {
}
