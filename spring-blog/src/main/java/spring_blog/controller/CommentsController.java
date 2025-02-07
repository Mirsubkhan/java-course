package spring_blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import jakarta.servlet.http.HttpSession;
import spring_blog.DTO.CommentDTO;
import spring_blog.model.Comment;
import spring_blog.model.Post;
import spring_blog.model.User;
import spring_blog.service.CommentService;
import spring_blog.service.PostService;
import spring_blog.service.UserService;
import java.util.List;

@Controller
public class CommentsController {
    private final CommentService commentService;
    private final PostService postService;
    private final UserService userService;

    public CommentsController(CommentService commentService, PostService postService, UserService userService) {
        this.commentService = commentService;
        this.postService = postService;
        this.userService = userService;
    }

    @GetMapping("comments/comments/{postId}")
    public String showComments(@PathVariable Long postId, Model model, HttpSession session) {
        Post post = postService.getPostById(postId);
        List<Comment> comments = commentService.getCommentsByPostId(postId);
        
        model.addAttribute("post", post);
        model.addAttribute("comments", comments);
        model.addAttribute("username", session.getAttribute("username"));
        
        return "comments";
    }
    
    @PostMapping("comments/comments/add")
    public String addComment(@RequestParam Long postId, 
                             @RequestParam String text, 
                             HttpSession session) {
        String username = (String) session.getAttribute("username");

        if (username == null || text.isBlank()) {
            return "comments/" + postId;
        }

        User user = userService.getUserByUsername(username);
        Post post = postService.getPostById(postId);

        CommentDTO commentDto = new CommentDTO(post.getId(), user, text, java.time.LocalDateTime.now());
        commentService.createComment(commentDto);

        return "redirect:/comments/comments/" + postId;
    }
}