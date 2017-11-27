package org.hibernate.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Post {

	private Long id;
	private String contenidoPost;

	public Post() {
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContenidoPost() {
		return contenidoPost;
	}

	public void setContenidoPost(String contenidoPost) {
		this.contenidoPost = contenidoPost;
	}

}
