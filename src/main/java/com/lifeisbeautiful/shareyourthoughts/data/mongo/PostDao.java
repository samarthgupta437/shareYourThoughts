package com.lifeisbeautiful.shareyourthoughts.data.mongo;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;

import com.lifeisbeautiful.shareyourthoughts.api.mongo.Post;

public class PostDao extends BasicDAO<Post, String> {

	public PostDao(Class<Post> entityClass, Datastore ds) {
		super(entityClass, ds);
		// TODO Auto-generated constructor stub
	}

}
