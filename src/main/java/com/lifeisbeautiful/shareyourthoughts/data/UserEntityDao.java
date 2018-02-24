package com.lifeisbeautiful.shareyourthoughts.data;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UserEntityDao {
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("shareyourthoughts");
	private EntityManager em =  emf.createEntityManager();
	
	private static final String GET_PASSWORD_FOR_EMAIL = 
			"Select user.password FROM UserEntity user WHERE user.email = :email" ;
	
	public Optional<String> getPassword(String email) {
		  List<String> resultList = em.createQuery(GET_PASSWORD_FOR_EMAIL, String.class).setParameter("email", email).getResultList();
		  if (resultList.isEmpty()) {
			  return Optional.empty();
		  } else {
			  return Optional.of(resultList.get(0));
		  }
	}

}
