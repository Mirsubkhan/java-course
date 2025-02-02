package spring_blog.service;


import java.util.List;

import org.springframework.stereotype.Service;

import spring_blog.DTO.PostDTO;
import spring_blog.model.Post;
import spring_blog.repository.PostRepository;

@Service
public class PostService {
	private final PostRepository postRepository;
	
	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}
	
	public boolean createPost(PostDTO postDto) {
		Post post = new Post(
			null, 
			postDto.getAuthor(), 
			postDto.getTitle(),
			postDto.getContent(), 
			postDto.getCreatedAt()
		);

		int rowsAffected = postRepository.create(post);
		return rowsAffected > 0;
	}
	
	public List<Post> getPosts(){
		return postRepository.findAll();
	}
	
	public Post getPostById(Long id) {
		return postRepository.findById(id);
	}
	
	public List<Post> getPostByAuthorId(Long id) {
		return postRepository.findByAuthorId(id);
	}
	
	public boolean deleteById(Long id) {
		int rowsAffected = postRepository.deleteById(id);
		return rowsAffected > 0;
	}
}
