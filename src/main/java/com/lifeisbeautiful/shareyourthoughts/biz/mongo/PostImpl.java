package com.lifeisbeautiful.shareyourthoughts.biz.mongo;

import java.util.List;

import org.bson.types.ObjectId;

import com.lifeisbeautiful.shareyourthoughts.api.InvalidContentException;
import com.lifeisbeautiful.shareyourthoughts.api.InvalidRatingValueException;
import com.lifeisbeautiful.shareyourthoughts.api.PostNotFoundException;
import com.lifeisbeautiful.shareyourthoughts.api.SytException;
import com.lifeisbeautiful.shareyourthoughts.api.UnauthorizedUserException;
import com.lifeisbeautiful.shareyourthoughts.api.mongo.IPost;
import com.lifeisbeautiful.shareyourthoughts.api.mongo.Post;
import com.lifeisbeautiful.shareyourthoughts.api.mongo.User;
import com.lifeisbeautiful.shareyourthoughts.data.mongo.PostDao;
import com.lifeisbeautiful.shareyourthoughts.util.DateTimeUtil;
import com.lifeisbeautiful.shareyourthoughts.util.MongoUtil;

public class PostImpl implements IPost {

	PostDao postDao = new PostDao(Post.class, MongoUtil.getDatastore());
	
	@Override
	public String addPost(String userId, Post post) throws UnauthorizedUserException, InvalidContentException {
		String postId = new ObjectId().toString();
		post.setId(postId);
		post.setCreateDate(DateTimeUtil.getCurrentTime());
		post.setLastUpdated(DateTimeUtil.getCurrentTime());
		post.setRating(0);
		post.setNumberOfRatingProvider(0);
		post.setAuthor(new User(userId));
		postDao.save(post);
		return postId;
	}

	@Override
	public Post getPost(int postId) throws PostNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> search(String key) throws SytException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editPost(Post post) throws UnauthorizedUserException, InvalidContentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addRating(int postId, int newRating) throws PostNotFoundException, InvalidRatingValueException {
		// TODO Auto-generated method stub
		
	}

}
