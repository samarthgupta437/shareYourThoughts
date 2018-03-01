package com.lifeisbeautiful.shareyourthoughts.biz;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.lifeisbeautiful.shareyourthoughts.api.IPost;
import com.lifeisbeautiful.shareyourthoughts.api.InvalidContentException;
import com.lifeisbeautiful.shareyourthoughts.api.PostEntity;
import com.lifeisbeautiful.shareyourthoughts.api.PostNotFoundException;
import com.lifeisbeautiful.shareyourthoughts.api.SytException;
import com.lifeisbeautiful.shareyourthoughts.api.UnauthorizedUserException;
import com.lifeisbeautiful.shareyourthoughts.data.PostEntityDao;
import com.lifeisbeautiful.shareyourthoughts.data.UserEntityDao;

public class Postimpl implements IPost {

	UserEntityDao userDao = new UserEntityDao();
	PostEntityDao postDao = new PostEntityDao();

	@Override
	public void addPost(PostEntity post) throws UnauthorizedUserException, InvalidContentException {
		if (post != null) {
			if (post.getAuthor() != null) {
				String userEmail = post.getAuthor().getEmail();
				String passwordSupplied = post.getAuthor().getPassword();
				Optional<String> passwordFromDB = userDao.getPassword(userEmail);
				if (passwordFromDB.isPresent() && passwordSupplied.equals(passwordFromDB.get())) {
					if (!(post.getTitle().trim().length() == 0)) {
						postDao.create(post);
					} else {
						throw new InvalidContentException("Title can not be empty");
					}

				} else {
					throw new UnauthorizedUserException("Invalid credentials for " + userEmail);
				}
			} else {
				throw new UnauthorizedUserException("Operation not allowed by provided user");
			}
		} else {
			throw new InvalidContentException("Invalid blog construct");
		}

	}

	@Override
	public PostEntity getPost(int postId) throws PostNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostEntity> search(String key) throws SytException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editPost(PostEntity post) throws UnauthorizedUserException, InvalidContentException {
		// TODO Auto-generated method stub

	}

	public List<PostEntity> getRecentPosts (int limit ) {
		// TODO
		return new ArrayList<>();
	}
}
