package org.hibernate.services;

import org.hibernate.beans.Post;
import org.hibernate.dao.impl.PostDaoImpl;

public class PostService {
	
	private PostDaoImpl postDao = new PostDaoImpl();
	
	public void guardarPost(String text) throws Exception{
		postDao.init();
		Post post = new Post();
		post.setContenidoPost(text);
		postDao.nuevo(post);
	}

}
