package com.lifeisbeautiful.shareyourthoughts.api;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class PostEntity {
	
	@Id @GeneratedValue
	private int id;
	
	private String title;
	
	private String content;
	
	private Date createDate;
	
	private Date lastUpdated;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private UserEntity author;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<CommentEntity> comments;
	
	private int rating;
	
	private long numberOfRatingProvider;
	
	public long getNumberOfRatingProvider() {
		
		
		return numberOfRatingProvider;
	}

	public void setNumberOfRatingProvider(long numberOfRatingProvider) {
		this.numberOfRatingProvider = numberOfRatingProvider;
	}

	public int getPostId() {
		return id;
	}

	public void setPostId(int postId) {
		this.id = postId;
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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public List<CommentEntity> getComments() {
		return comments;
	}

	public void setComments(List<CommentEntity> comments) {
		this.comments = comments;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public UserEntity getAuthor() {
		return author;
	}

	public void setAuthor(UserEntity author) {
		this.author = author;
	}
}
