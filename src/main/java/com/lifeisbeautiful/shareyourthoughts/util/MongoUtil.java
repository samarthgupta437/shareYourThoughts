package com.lifeisbeautiful.shareyourthoughts.util;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

public class MongoUtil {
	static final MongoClient mongoClient = new MongoClient("127.0.0.1:27017");
	static final Morphia morphia = new Morphia();
	static final String databaseName = "syt";
	
	public static Datastore getDatastore() {
		return morphia.createDatastore(mongoClient, databaseName);
	}
}
