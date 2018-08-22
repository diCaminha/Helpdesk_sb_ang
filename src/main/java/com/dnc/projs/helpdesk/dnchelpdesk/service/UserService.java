package com.dnc.projs.helpdesk.dnchelpdesk.service;

import com.dnc.projs.helpdesk.dnchelpdesk.domain.User;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface UserService {

	User findByEmail(String email);

	User createOrUpdate(User user);

	Optional<User> findById(String id);

	void delete(String userId);

	Page<User> findAll(int page, int count);



}
