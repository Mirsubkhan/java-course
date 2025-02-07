package spring_blog.service;

import spring_blog.DTO.CommentDTO;
import spring_blog.model.Comment;

import java.util.List;

import org.springframework.stereotype.Service;

import spring_blog.repository.CommentRepository;

@Service
public class CommentService {
	private final CommentRepository commentRepository;
	
	public CommentService(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}
	
	public boolean createComment(CommentDTO commentDto) {
		Comment comment = new Comment(
				null,
				commentDto.getPostId(),
				commentDto.getAuthor(),
				commentDto.getContent(),
				commentDto.getCreatedAt());
		
		int rowsAffected = commentRepository.create(comment);
		return rowsAffected > 0;
	}
	
	public List<Comment> getCommentsByPostId(Long id){
		return commentRepository.findById(id);
	}
	
	public boolean deleteById(Long id) {
		int rowsAffected = commentRepository.deleteById(id);
		return rowsAffected > 0;
	}
}
