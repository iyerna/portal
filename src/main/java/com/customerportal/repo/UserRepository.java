package com.customerportal.repo;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.repository.annotation.RestResource;

import com.customerportal.model.UserEntity;

/**
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
@RestResource(path = "users")
public interface UserRepository extends JpaRepository<UserEntity, Long> {
	
	@RestResource(path = "find-by-username")
	UserEntity findByUsername(@Param("username") String username);
	
	@RestResource(path = "find-by-username-in")
	List<UserEntity> findByUsernameIn(@Param("username") Collection<String> usernames);
} 
