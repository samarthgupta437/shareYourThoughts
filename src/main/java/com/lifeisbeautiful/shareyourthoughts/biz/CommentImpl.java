package com.lifeisbeautiful.shareyourthoughts.biz;

import com.lifeisbeautiful.shareyourthoughts.api.CommentEntity;
import com.lifeisbeautiful.shareyourthoughts.api.IComment;
import com.lifeisbeautiful.shareyourthoughts.api.ResourceNotFoundException;
import com.lifeisbeautiful.shareyourthoughts.api.UnauthorizedUserException;

public class CommentImpl implements IComment {

	@Override
	public void post(long postId, CommentEntity comment) throws UnauthorizedUserException {
		// TODO Auto-generated method stub

	}

	@Override
	public CommentEntity get(long commentId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
