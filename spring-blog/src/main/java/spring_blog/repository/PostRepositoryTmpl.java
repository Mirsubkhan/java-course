package spring_blog.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import spring_blog.model.Post;

@Repository
public class PostRepositoryTmpl implements PostRepository {
    private final JdbcTemplate jdbcTemplate;
    private final UserRepository userRepository;
    
    public PostRepositoryTmpl(JdbcTemplate jdbcTemplate, UserRepository userRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.userRepository = userRepository;
    }
    
    @Override
    public List<Post> findAll() {
        String query = "SELECT * FROM posts";
        
        return jdbcTemplate.query(query, (rs, rowNum) -> getPost(rs));
    }

    @Override
    public Post findById(Long id) {
        String query = "SELECT * FROM posts WHERE id = (?)";

        return jdbcTemplate.queryForObject(query, (rs, rowNum) -> getPost(rs), id);
    }
    
    @Override
    public List<Post> findByAuthorId(Long id) {
        String query = "SELECT * FROM posts WHERE author_id = (?)";

        return jdbcTemplate.query(query, (rs, rowNum) -> getPost(rs), id);
    }

    @Override
    public int create(Post post) {
        String query = "INSERT INTO posts (title, author_id, content, created_at) VALUES (?, ?, ?, ?)";
        Object[] args = new Object[] {post.getTitle(), post.getAuthor().getId(), post.getContent(), Timestamp.valueOf(post.getCreatedAt())};

        return jdbcTemplate.update(query, args);
    }

    @Override
    public int update(Post post) {
        String query = "UPDATE posts SET title = (?), content = (?) WHERE id = (?)";
        Object[] args = new Object[] {post.getTitle(), post.getContent(), post.getId()};
        
        return jdbcTemplate.update(query, args);
    }

    @Override
    public int deleteById(Long id) {
        String query = "DELETE FROM posts WHERE author_id = ?";
        return jdbcTemplate.update(query, id);
    }
    
    private Post getPost(ResultSet rs) {
    	try {
			return new Post(
			    rs.getLong("id"),
			    userRepository.findById(rs.getLong("author_id")),
			    rs.getString("title"),
			    rs.getString("content"),
			    rs.getTimestamp("created_at").toLocalDateTime()
			);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
    }
}