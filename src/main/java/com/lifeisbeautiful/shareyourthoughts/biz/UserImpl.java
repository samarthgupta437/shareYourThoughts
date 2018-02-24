package com.lifeisbeautiful.shareyourthoughts.biz;

import java.util.List;

import com.lifeisbeautiful.shareyourthoughts.api.IUser;
import com.lifeisbeautiful.shareyourthoughts.api.InvaidUserNamePasswordException;
import com.lifeisbeautiful.shareyourthoughts.api.PostEntity;
import com.lifeisbeautiful.shareyourthoughts.api.UserAlreadyExistsException;
import com.lifeisbeautiful.shareyourthoughts.api.UserEntity;

public class UserImpl implements IUser {

	@Override
	public void addUser(UserEntity user) throws UserAlreadyExistsException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PostEntity> signInUser(String email, String password) throws InvaidUserNamePasswordException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void signOutUser(String email) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean validateUser(String email, String password) {
		// TODO Auto-generated method stub
		return false;
	}

}
