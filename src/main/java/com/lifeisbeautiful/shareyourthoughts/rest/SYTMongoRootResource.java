package com.lifeisbeautiful.shareyourthoughts.rest;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.lifeisbeautiful.shareyourthoughts.api.SytException;
import com.lifeisbeautiful.shareyourthoughts.api.mongo.IPost;
import com.lifeisbeautiful.shareyourthoughts.api.mongo.Post;
import com.lifeisbeautiful.shareyourthoughts.biz.mongo.PostImpl;

@Path("/v2")
@Consumes(MediaType.APPLICATION_JSON)
@Produces({ MediaType.APPLICATION_JSON })
public class SYTMongoRootResource {
	
	private IPost postManager = new PostImpl();
	
	@POST
	@Path("/users/{userId}/posts")
	public Response addUserPost (@PathParam("userId") String userId, Post post) {
		try {
			return Response.created(new URI(postManager.addPost(userId, post))).build();
		} catch (Exception e) {
			throw new SytException();
		} 
	}
}
