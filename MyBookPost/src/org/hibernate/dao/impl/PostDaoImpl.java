package org.hibernate.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.beans.Post;
import org.hibernate.dao.PostDao;

public class PostDaoImpl implements PostDao {

	private static EntityManagerFactory entityManagerFactory;

	public void init() {
		entityManagerFactory = Persistence
				.createEntityManagerFactory("org.hibernate.tp.jpa");
	}

	public  void tearDown() throws Exception {
		entityManagerFactory.close();
	}

	public void nuevo(Post post) throws Exception {
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(post);
		entityManager.getTransaction().commit();
		entityManager.close();
		tearDown();
	}

	public void update(Post post) {

	}

	public void delete(Post post) {

	}

}
