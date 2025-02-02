package spring_blog.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import spring_blog.model.Comment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class CommentRepositoryTmpl implements CommentRepository {
    private final JdbcTemplate jdbcTemplate;
    private final UserRepository userRepository;

    public CommentRepositoryTmpl(JdbcTemplate jdbcTemplate, UserRepository userRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.userRepository = userRepository;
    }

    @Override
    public List<Comment> findById(Long id) {
        String query = "SELECT * FROM comments c JOIN posts p ON c.post_id = p.id WHERE c.post_id = (?)";

        return jdbcTemplate.query(query, (rs, rowNum) -> getComment(rs), id);
    }

    @Override
    public int create(Comment comment) {
        String query = "INSERT INTO comments (post_id, author_id, content, created_at) VALUES (?, ?, ?, ?)";
        Object[] args = new Object[] { comment.getPostId(), comment.getAuthor().getId(), comment.getContent(), Timestamp.valueOf(comment.getCreatedAt()) };
        
        return jdbcTemplate.update(query, args);
    }

    @Override
    public int update(Comment comment) {
        String query = "UPDATE comments SET content = (?) WHERE id = (?)";
        Object[] args = new Object[] { comment.getContent(), comment.getId() };

        
        return jdbcTemplate.update(query, args);
    }

    @Override
    public int deleteById(Long id) {
        String query = "DELETE FROM comments WHERE post_id = (?)";
        
        return jdbcTemplate.update(query, id);
    }
    
    private Comment getComment(ResultSet rs) {
    	try {
			return new Comment(
			    rs.getLong("id"),
			    rs.getLong("post_id"),
			    userRepository.findById(rs.getLong("author_id")),
			    rs.getString("content"),
			    rs.getTimestamp("created_at").toLocalDateTime()
			);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
    }
}
