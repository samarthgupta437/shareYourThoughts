package com.lifeisbeautiful.shareyourthoughts.biz;

import java.util.List;

import com.lifeisbeautiful.shareyourthoughts.api.IUser;
import com.lifeisbeautiful.shareyourthoughts.api.InvaidUserNamePasswordException;
import com.lifeisbeautiful.shareyourthoughts.api.InvalidContentException;
import com.lifeisbeautiful.shareyourthoughts.api.PostEntity;
import com.lifeisbeautiful.shareyourthoughts.api.UnauthorizedUserException;
import com.lifeisbeautiful.shareyourthoughts.api.UserAlreadyExistsException;
import com.lifeisbeautiful.shareyourthoughts.api.UserEntity;
import com.lifeisbeautiful.shareyourthoughts.data.PostEntityDao;
import com.lifeisbeautiful.shareyourthoughts.data.UserEntityDao;
import com.mysql.jdbc.StringUtils;

public class UserImpl implements IUser {
	UserEntityDao userDao = new UserEntityDao();
	PostEntityDao postDao = new PostEntityDao();

	@Override
	public void addUser(UserEntity user) throws UserAlreadyExistsException {
		if (StringUtils.isEmptyOrWhitespaceOnly(user.getEmail())
				|| StringUtils.isEmptyOrWhitespaceOnly(user.getPassword())
				|| StringUtils.isEmptyOrWhitespaceOnly(user.getName())) {
			throw new InvalidContentException("Provide valid values for name, password and email");
		} else {
			if (userDao.isUserRegistered(user.getEmail())) {
				
			} else {
				userDao.create(user);
			}
		}
		
	}

	@Override
	public List<PostEntity> signInUser(String email, String password) throws InvaidUserNamePasswordException {
		if (StringUtils.isEmptyOrWhitespaceOnly(email) 
				|| StringUtils.isEmptyOrWhitespaceOnly(password)) {
			throw new InvalidContentException("Provide valid values for password and email");
		} else {
			if (userDao.getPassword(email).isPresent() && userDao.getPassword(email).get().equals(password)) {
				return postDao.getAllPostByUserEmail(email);
			} else {
				throw new UnauthorizedUserException("Invalid email / password combination");
			}
		}

	}

	@Override
	public void signOutUser(String email) {
		// TODO Auto-generated method stub
		
	}

	public UserEntity getUserById(int userId) {
		// TODO Auto-generated method stub
		return new UserEntity();
	}
}
