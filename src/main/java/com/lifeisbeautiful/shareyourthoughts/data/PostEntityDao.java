package com.lifeisbeautiful.shareyourthoughts.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lifeisbeautiful.shareyourthoughts.api.PostEntity;

public class PostEntityDao {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("shareyourthoughts");
	private EntityManager em =  emf.createEntityManager();
	
	private static final String GET_ALL_POST_BY_EMAIL = 
			"select post from PostEntity post where post.author.email = :email";
	
	public void create(PostEntity post) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(post);
		em.getTransaction().commit();
		em.close();
	}

	public List<PostEntity> getAllPostByUserEmail(String email) {
		return em.createQuery(GET_ALL_POST_BY_EMAIL, PostEntity.class).setParameter("email", email).getResultList();
	}
}
