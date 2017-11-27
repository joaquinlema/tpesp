package org.hibernate.dao;

import org.hibernate.beans.Post;

public interface PostDao   {

	public abstract void nuevo(Post post) throws Exception;

	public abstract void update(Post post);

	public abstract void delete(Post post);
}
