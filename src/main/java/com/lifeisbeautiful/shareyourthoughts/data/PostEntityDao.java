package com.lifeisbeautiful.shareyourthoughts.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lifeisbeautiful.shareyourthoughts.api.PostEntity;

public class PostEntityDao {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("shareyourthoughts");
	private EntityManager em =  emf.createEntityManager();
	
	public void create(PostEntity post) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(post);
		em.getTransaction().commit();
		em.close();
	}
}
