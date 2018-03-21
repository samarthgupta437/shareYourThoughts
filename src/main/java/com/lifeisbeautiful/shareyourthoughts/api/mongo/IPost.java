package com.lifeisbeautiful.shareyourthoughts.api.mongo;

import java.util.List;

import com.lifeisbeautiful.shareyourthoughts.api.InvalidContentException;
import com.lifeisbeautiful.shareyourthoughts.api.InvalidRatingValueException;
import com.lifeisbeautiful.shareyourthoughts.api.PostNotFoundException;
import com.lifeisbeautiful.shareyourthoughts.api.SytException;
import com.lifeisbeautiful.shareyourthoughts.api.UnauthorizedUserException;

public interface IPost {
	public Post getPost(int postId) throws PostNotFoundException ;
	
	public List<Post> search(String key) throws SytException ;
	
	public void editPost(Post post)  throws UnauthorizedUserException, InvalidContentException ;
	
	public void addRating(int postId, int newRating) throws PostNotFoundException, InvalidRatingValueException ;

	String addPost(String userId, Post post) throws UnauthorizedUserException, InvalidContentException;
}
