package co.id.jasaraharja.microservices.auth.service;

import org.springframework.data.repository.CrudRepository;

import co.id.jasaraharja.microservices.auth.domain.User;

public interface UserRepository extends CrudRepository<User, String> {

}
