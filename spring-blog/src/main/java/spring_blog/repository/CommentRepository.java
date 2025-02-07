package spring_blog.repository;

import java.util.List;

import spring_blog.model.Comment;

public interface CommentRepository {
	List<Comment> findById(Long id);
	int create(Comment comment);
	int update (Comment comment);
	int deleteById(Long id);
}
