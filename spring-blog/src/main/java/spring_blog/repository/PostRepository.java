package spring_blog.repository;

import java.util.List;

import spring_blog.model.Post;

public interface PostRepository {
	List<Post> findAll();
	Post findById(Long id);
	List<Post> findByAuthorId(Long id);
	int create(Post post);
	int update (Post post);
	int deleteById(Long id);
}
