package com.lifeisbeautiful.shareyourthoughts.api.mongo;

import java.util.List;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

@Entity
public class Post {
	
	@Id
	private String id;
	private String title;
	private String content;
	private String createDate;
	private String lastUpdated;
	@Reference
	private User author;
	@Reference
	private List<Comment> comments;
	private int rating;
	private long numberOfRatingProvider;
	
	//Getter and Setters Starts
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public long getNumberOfRatingProvider() {
		return numberOfRatingProvider;
	}
	public void setNumberOfRatingProvider(long numberOfRatingProvider) {
		this.numberOfRatingProvider = numberOfRatingProvider;
	}
	// Getter Setters Ends

}
