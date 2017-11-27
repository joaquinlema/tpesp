package org.hibernate.dto;

public class PostDto {
	private Long id;
	private String contenidoPost;

	public PostDto(String text) {
		contenidoPost=text;
	}

	public String getContenidoPost() {
		return contenidoPost;
	}

	public void setContenidoPost(String contenidoPost) {
		this.contenidoPost = contenidoPost;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
