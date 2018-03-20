package com.lifeisbeautiful.shareyourthoughts.api.mongo;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.lifeisbeautiful.shareyourthoughts.data.mongo.PostDao;
import com.lifeisbeautiful.shareyourthoughts.data.mongo.UserDao;
import com.mongodb.MongoClient;

public class MongoMain {
	public static void main(String[] args) {
		MongoClient mongoClient = new MongoClient("127.0.0.1:27017");
		Morphia morphia = new Morphia();
		String databaseName = "blogtest";
		Datastore datastore = morphia.createDatastore(mongoClient, databaseName);

		UserDao udao = new UserDao(User.class, datastore);
		User u = new User();
		u.setEmail("myEmail");
		u.setId(new ObjectId().toString());
		u.setUserName("user1");
		u.setPassword("new password");
		udao.save(u);
		
		
		PostDao dao = new PostDao(Post.class, datastore);
		Post p = new Post();
		p.setId(new ObjectId().toString());
		p.setTitle("mytitle");
		p.setContent("blog data here");
		p.setAuthor(u);
		dao.save(p);
	}
}
