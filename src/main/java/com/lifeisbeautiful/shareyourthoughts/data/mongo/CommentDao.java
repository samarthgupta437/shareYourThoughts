package com.lifeisbeautiful.shareyourthoughts.data.mongo;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;

import com.lifeisbeautiful.shareyourthoughts.api.mongo.Comment;

public class CommentDao extends BasicDAO<Comment, String> {

	public CommentDao(Class<Comment> entityClass, Datastore ds) {
		super(entityClass, ds);
		// TODO Auto-generated constructor stub
	}

}
