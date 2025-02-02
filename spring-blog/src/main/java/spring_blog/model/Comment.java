package spring_blog.model;

import java.time.LocalDateTime;

public class Comment {
    private Long id;
    private Long post_id;
    private User author;
    private String content;
    private LocalDateTime createdAt;

    public Comment(Long id, Long post_id, User author, String content, LocalDateTime createdAt) {
        this.id = id;
        this.post_id = post_id;
        this.author = author;
        this.content = content;
        this.createdAt = createdAt;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getPostId() { return post_id; }
    public void setPostId(Long post_id) { this.post_id = post_id; }

    public User getAuthor() { return author; }
    public void setAuthor(User author) { this.author = author; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
