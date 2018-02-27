package com.lifeisbeautiful.shareyourthoughts.api;

import java.util.List;

public interface IPost {

	public void addPost(PostEntity post) throws UnauthorizedUserException, InvalidContentException ;
	
	public PostEntity getPost(int postId) throws PostNotFoundException ;
	
	public List<PostEntity> search(String key) throws SytException ;
	
	public void editPost(PostEntity post)  throws UnauthorizedUserException, InvalidContentException ;
	
	public void addRating(int postId, int newRating) throws PostNotFoundException, InvalidRatingValueException ;
}
