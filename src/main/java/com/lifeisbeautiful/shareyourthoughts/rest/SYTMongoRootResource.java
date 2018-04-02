package com.lifeisbeautiful.shareyourthoughts.rest;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.lifeisbeautiful.shareyourthoughts.api.SytException;
import com.lifeisbeautiful.shareyourthoughts.api.mongo.IPost;
import com.lifeisbeautiful.shareyourthoughts.api.mongo.IUser;
import com.lifeisbeautiful.shareyourthoughts.api.mongo.Post;
import com.lifeisbeautiful.shareyourthoughts.api.mongo.User;
import com.lifeisbeautiful.shareyourthoughts.biz.mongo.PostImpl;
import com.lifeisbeautiful.shareyourthoughts.biz.mongo.UserImpl;

@Path("/v2")
@Consumes(MediaType.APPLICATION_JSON)
@Produces({ MediaType.APPLICATION_JSON })
public class SYTMongoRootResource {
	
	private IPost postManager = new PostImpl();
	private IUser userManager = new UserImpl();
	
	@POST
	@Path("/users/{userId}/posts")
	public Response addUserPost (@PathParam("userId") String userId, Post post) {
		try {
			return Response.created(new URI(postManager.addPost(userId, post))).build();
		} catch (Exception e) {
			throw new SytException();
		} 
	}
	
	@POST
	@Path("/users")
	public Response signUpUser(User user) {
		try {
			return Response.created(new URI(userManager.add(user))).build();
		} catch (Exception e) {
			throw new SytException();
		} 
	}
	
	@GET
	@Path("/posts")
	public Response findPost( @QueryParam("key") @DefaultValue("") String key) {
		try {
			List<Post> matchedPosts = new ArrayList<Post>();
			return Response.ok().entity(matchedPosts).build();
		} catch (Exception e) {
			throw new SytException();
		}
	}
}
