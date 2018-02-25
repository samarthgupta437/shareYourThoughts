package com.lifeisbeautiful.shareyourthoughts.data;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lifeisbeautiful.shareyourthoughts.api.UserEntity;

public class UserEntityDao {
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("shareyourthoughts");
	private EntityManager em =  emf.createEntityManager();
	
	private static final String GET_PASSWORD_FOR_EMAIL = 
			"Select user.password FROM UserEntity user WHERE user.email = :email" ;
	
	private static final String GET_USER_BY_EMAIL = 
			"Select user FROM UserEntity user WHERE user.email = :email" ;
	
	public Optional<String> getPassword(String email) {
		  List<String> resultList = em.createQuery(GET_PASSWORD_FOR_EMAIL, String.class).setParameter("email", email).getResultList();
		  if (resultList.isEmpty()) {
			  return Optional.empty();
		  } else {
			  return Optional.of(resultList.get(0));
		  }
	}

	public boolean isUserRegistered(String email) {
		if (getUserEntityByEmail(email).isPresent()) {
			return true;
		}
		return false;
	}
	
	public Optional<UserEntity> getUserEntityByEmail(String email) {
		List<UserEntity> userList = em.createQuery(GET_USER_BY_EMAIL, UserEntity.class).setParameter("email", email).getResultList();
		if (userList.isEmpty()) {
			return Optional.empty();
		} else {
			return Optional.of(userList.get(0));
		}
	}

	public void create(UserEntity user) {
		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		em.close();
	}

}
