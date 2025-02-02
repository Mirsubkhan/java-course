package spring_blog.DTO;

import java.time.LocalDateTime;
import java.util.List;

import spring_blog.model.Comment;
import spring_blog.model.User;

public class PostDTO {
	 private User author;
	    private List<Comment> comments;
	    private String title;
	    private String content;
	    private LocalDateTime createdAt;

	    public PostDTO(User author, List<Comment> comments, String title, String content, LocalDateTime createdAt) {
	        this.author = author;
	        this.comments = comments;
	        this.title = title;
	        this.content = content;
	        this.createdAt = createdAt;
	    }

	    public User getAuthor() { return author; }
	    public void setAuthor(User author) { this.author = author; }
	    
	    public List<Comment> getComments() { return comments; }
	    public void setComments(List<Comment> comments) { this.comments = comments; }

	    public String getTitle() { return title; }
	    public void setTitle(String title) { this.title = title; }

	    public String getContent() { return content; }
	    public void setContent(String content) { this.content = content; }
	    
	    public LocalDateTime getCreatedAt() { return createdAt; }
	    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
