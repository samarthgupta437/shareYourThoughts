package com.lifeisbeautiful.shareyourthoughts.api.mongo;

import com.lifeisbeautiful.shareyourthoughts.api.UserAlreadyExistsException;

public interface IUser {
	String add(User user) throws UserAlreadyExistsException;
}
