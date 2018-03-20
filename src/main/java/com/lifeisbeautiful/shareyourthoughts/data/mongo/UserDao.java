package com.lifeisbeautiful.shareyourthoughts.data.mongo;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;

import com.lifeisbeautiful.shareyourthoughts.api.mongo.User;

public class UserDao extends BasicDAO<User, String> {

	public UserDao(Class<User> entityClass, Datastore ds) {
		super(entityClass, ds);
		// TODO Auto-generated constructor stub
	}

}
