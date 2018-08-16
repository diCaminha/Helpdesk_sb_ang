package com.dnc.projs.helpdesk.dnchelpdesk.service;

import com.dnc.projs.helpdesk.dnchelpdesk.domain.User;
import org.springframework.data.domain.Page;

public interface UserService {

	User findByEmail(String email);

	User createOrUpdate(User user);

	User findById(String id);

	void delete(String userId);

	Page<User> findAll(int page, int count);



}
