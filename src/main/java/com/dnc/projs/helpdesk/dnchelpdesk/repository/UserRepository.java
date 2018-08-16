package com.dnc.projs.helpdesk.dnchelpdesk.repository;

import com.dnc.projs.helpdesk.dnchelpdesk.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

	User findByEmail(String email);

}
