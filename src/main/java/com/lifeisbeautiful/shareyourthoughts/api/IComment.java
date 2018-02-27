package com.lifeisbeautiful.shareyourthoughts.api;

public interface IComment {

	public void post(long postId, CommentEntity comment) throws UnauthorizedUserException;
	
	public CommentEntity get(long commentId) throws ResourceNotFoundException;
}
