package com.cactus.domain;


import java.util.List;

import com.cactus.entities.User;

public interface UserMapper {
	void insertUser(User user);

	User findUser(String id);

	List<User> findAllUsers();
}
