package com.lifeisbeautiful.shareyourthoughts.data;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lifeisbeautiful.shareyourthoughts.api.PostEntity;

public class PostEntityDao {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("shareyourthoughts");
	private EntityManager em = emf.createEntityManager();

	private static final String GET_ALL_POST_BY_EMAIL = 
			"select post from PostEntity post where post.author.email = :email";

	private static final String GET_POST_BY_ID = 
			"select post from PostEntity post where post.id = :postId";
	
	private static final String UPDATE_RATING_FOR_POST = 
			"UPDATE PostEntity post SET post.rating = :updatedRating WHERE post.id = :postId";
	
	private static final String UPDATE_RATING_PROVIDERS_FOR_POST = 
			"UPDATE PostEntity post SET post.numberOfRatingProvider = :numberOfRatingProvider WHERE post.id = :postId";

	private static final String GET_ALL_POST = 
			"SELECT post from PostEntity post";
	
	public void create(PostEntity post) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(post);
		em.getTransaction().commit();
		em.close();
	}

	public List<PostEntity> getAllPostByUserEmail(String email) {
		return em.createQuery(GET_ALL_POST_BY_EMAIL, PostEntity.class)
				.setParameter("email", email)
				.getResultList();
	}

	public Optional<PostEntity> getPostById(int postId) {
		PostEntity post = em.createQuery(GET_POST_BY_ID, PostEntity.class)
				.setParameter("postId", postId)
				.getSingleResult();
		if (post == null) {
			return Optional.empty();
		} else {
			return Optional.of(post);
		}
	}

	public int getCurrentRatingForPostById(int postId) {
		Optional<PostEntity> post = getPostById(postId);
		if (post.isPresent()) {
			return post.get().getRating();
			}
		return 0;
	}

	public long currentRatingProviderNumber(int postId) {
		Optional<PostEntity> post = getPostById(postId);
		if (post.isPresent()) {
			return post.get().getNumberOfRatingProvider();
			}
		return 0;
	}

	public void setRatingForPost(int postId, int updatedRating) {
		em.createQuery(UPDATE_RATING_FOR_POST)
		.setParameter("postId", postId)
		.setParameter("updatedRating", updatedRating)
		.executeUpdate();
		
	}

	public void setCurrentRatingProviderNumbers(int postId, long updatedRatingPorviders) {
		em.createQuery(UPDATE_RATING_PROVIDERS_FOR_POST)
		.setParameter("postId", postId)
		.setParameter("updatedRatingPorviders", updatedRatingPorviders)
		.executeUpdate();
	}

	public List<PostEntity> getAllPost() {
		return em.createQuery(GET_ALL_POST, PostEntity.class).getResultList();
	}
}
