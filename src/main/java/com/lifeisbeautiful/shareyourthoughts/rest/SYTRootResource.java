package com.lifeisbeautiful.shareyourthoughts.rest;

import java.net.URI;
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

import com.lifeisbeautiful.shareyourthoughts.api.CommentEntity;
import com.lifeisbeautiful.shareyourthoughts.api.PostEntity;
import com.lifeisbeautiful.shareyourthoughts.api.SytException;
import com.lifeisbeautiful.shareyourthoughts.api.UnauthorizedUserException;
import com.lifeisbeautiful.shareyourthoughts.api.UserEntity;
import com.lifeisbeautiful.shareyourthoughts.biz.CommentImpl;
import com.lifeisbeautiful.shareyourthoughts.biz.Postimpl;
import com.lifeisbeautiful.shareyourthoughts.biz.UserImpl;

@Path("/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces({ MediaType.APPLICATION_JSON })
public class SYTRootResource {
	
	private Postimpl posts = new Postimpl();   

	private UserImpl users = new UserImpl();

	private CommentImpl comments = new CommentImpl();
	 
	@GET
	@Path("/recentPosts")   
	public Response getRecentPosts() {
		try {
			System.out.println("Getting recent posts");     
			List<PostEntity> recentPosts = posts.getRecentPosts(10);
			return Response.ok().entity(recentPosts).build();
		} catch (Exception e) {
			throw new SytException();
		}

	}

	@GET
	@Path("/posts/{postId}")
	public Response getPost( @PathParam("postId") int postId) {
		
		
		try {  
			PostEntity specificPost = posts.getPost(postId);
			return Response.ok().entity(specificPost).build();
		} catch (Exception e) {
			throw new SytException();
		}
	}

	@GET
	@Path("/posts")
	public Response findPost( @QueryParam("key") @DefaultValue("") String key) {
		try {
			List<PostEntity> matchedPosts = posts.search(key);
			return Response.ok().entity(matchedPosts).build();
		} catch (Exception e) {
			throw new SytException();
		}

	}
	
	@POST
	@Path("/users")
	public Response addUser( UserEntity user) {
		try {
			users.addUser(user);
			return Response.created(new URI(user.getName() + "")).build();
		} catch (Exception e) {
			throw new SytException();
		}

	}

	@POST
	@Path("/users/login")
	public Response signInUser( @PathParam("email") String email, 
			@PathParam("password") String password) {
		try {
			List<PostEntity> userSpecificPosts = users.signInUser(email, password);
			return Response.ok().entity(userSpecificPosts).build();
		} catch (Exception e) {
			throw new SytException();
		}

	}

	@POST
	@Path("/users/{UserId}")
	public Response signOutUser( @PathParam("UserId") int userId) {
		try {
			UserEntity author = users.getUserById(userId);
			users.signOutUser(author.getEmail());
			return getRecentPosts();
		} catch (Exception e) {
			throw new SytException();
		}

	}

	@GET
	@Path("/users/{userId}/posts/{postId}")
	public Response getUserPost( @PathParam("userId") int userId, @PathParam("postId") int postId) {
		try {
			
			PostEntity specificPost = posts.getPost(postId);
			return Response.ok().entity(specificPost).build();
		} catch (Exception e) {
			throw new SytException();
		}

	}

	@POST
	@Path("/users/{userId}/posts")
	public Response addUserPost ( @PathParam("userId") int userId, PostEntity post) {
		try {
			UserEntity author = users.getUserById(userId);
			post.setAuthor(author);
			posts.addPost(post);
			return Response.created(new URI(post.getPostId() + "")).build();
		} catch (Exception e) {
			throw new SytException();
		}

	}

	@POST
	@Path("/users/{userId}/posts/{postId}")
	public Response editUserPost ( @PathParam("userId") int userId, @PathParam("postId") int postId, PostEntity editedPost) {
		try {
			UserEntity author = users.getUserById(userId);
			PostEntity post = posts.getPost(postId);
			if ( post.getAuthor().equals(author) ) {
				// allowed to edit post
				post.setTitle(editedPost.getTitle());
				post.setContent(editedPost.getContent());
				post.setLastUpdated(editedPost.getLastUpdated());
				posts.editPost(post);
				return Response.ok().entity(post).build();
			} else {
				throw new UnauthorizedUserException(null);
			}
		} catch (Exception e) {
			throw new SytException();
		}

	}
	
	@POST
	@Path("/users/{userId}/posts/{postId}/comments")
	public Response addComment ( @PathParam("userId") int userId, @PathParam("postId") int postId, CommentEntity comment) {
		try {
			UserEntity author = users.getUserById(userId);
			if (author != null) {
				// only users are allowed to comment
				comments.post(postId, comment);
				return Response.ok().entity(comment).build();
			}
		} catch (Exception e) {
			throw new SytException();
		}
		return null;
	}
	
	@GET
	@Path("/users/{userId}/posts/{postId}/comments/{commentId}")
	public Response getComment( @PathParam("commentId") int commentId) {
		try {
			CommentEntity comment = comments.get(commentId);
			return Response.ok().entity(comment).build();
		} catch (Exception e) {
			throw new SytException();
		}

	}

	@GET
	@Path("/users/{userId}/posts/{postId}/comments")
	public Response getAllCommentsForPost( @PathParam("postId") int postId) {
		try {
			List<CommentEntity> comments = posts.getPost(postId).getComments();
			return Response.ok().entity(comments).build();
		} catch (Exception e) {
			throw new SytException();
		}

	}
}
