package com.customerportal.service.impl;

import static org.springframework.util.Assert.notNull;

import javax.inject.Inject;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.customerportal.model.UserEntity;
import com.customerportal.repo.UserRepository;
import com.customerportal.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Inject private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		notNull(username, "username can't be null");
		UserEntity user = userRepo.findByUsername(username);
		if (user == null) { throw new UsernameNotFoundException(username); }
		return user;
	}
}
