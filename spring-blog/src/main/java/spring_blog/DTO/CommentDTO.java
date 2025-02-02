package spring_blog.DTO;

import java.time.LocalDateTime;

import spring_blog.model.User;

public class CommentDTO {
    private Long post_id;
    private User author;
    private String content;
    private LocalDateTime createdAt;

    public CommentDTO(Long post_id, User author, String content, LocalDateTime createdAt) {
        this.post_id = post_id;
        this.author = author;
        this.content = content;
        this.createdAt = createdAt;
    }

    public Long getPostId() { return post_id; }
    public void setPostId(Long post_id) { this.post_id = post_id; }

    public User getAuthor() { return author; }
    public void setAuthor(User author) { this.author = author; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
