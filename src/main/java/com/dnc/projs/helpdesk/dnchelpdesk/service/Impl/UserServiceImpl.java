package com.dnc.projs.helpdesk.dnchelpdesk.service.Impl;

import com.dnc.projs.helpdesk.dnchelpdesk.domain.User;
import com.dnc.projs.helpdesk.dnchelpdesk.repository.UserRepository;
import com.dnc.projs.helpdesk.dnchelpdesk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public User createOrUpdate(User user) {
		return userRepository.save(user);
	}

	@Override
	public Optional<User> findById(String id) {
		return Optional.of(this.userRepository.findById(id).get());
	}

	@Override
	public void delete(String userId) {

	}

	@Override
	public Page<User> findAll(int page, int count) {

		Pageable pages = new PageRequest(page,count);
		return this.userRepository.findAll(pages);
	}
}
