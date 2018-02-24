package com.lifeisbeautiful.shareyourthoughts.api;

import java.util.List;

public interface IUser {

	public void addUser(UserEntity user)  throws UserAlreadyExistsException;
	
	public List<PostEntity> signInUser(String email, String password) throws InvaidUserNamePasswordException ;
	
	public void signOutUser(String email) ; 
	
	public boolean validateUser(String email, String password) ;
	
}
