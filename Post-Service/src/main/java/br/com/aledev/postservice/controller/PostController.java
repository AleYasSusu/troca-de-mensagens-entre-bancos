package br.com.aledev.postservice.controller;

import br.com.aledev.postservice.exception.PostNotFoundException;
import br.com.aledev.postservice.model.Comment;
import br.com.aledev.postservice.model.Post;
import br.com.aledev.postservice.service.PostService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;



    @PostMapping
    @Operation(description = "Endpoint para criar um post")
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        Post createdPost = postService.createPost(post);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPost);
    }

    @GetMapping("/{postId}")
    @Operation(description = "Endpoint para buscar um post por ID")
    public ResponseEntity<Post> getPostById(@PathVariable ("postId") Long postId) {
        Post post = postService.findPostById(postId);
        return ResponseEntity.ok(post);
    }

    @GetMapping
    @Operation(description = "Endpoint para listar todos os posts")
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> posts = postService.getAllPosts();
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/{postId}/comments")
    @Operation(description ="Endpoint para buscar comentários por ID do post")
    public ResponseEntity<List<Comment>> getCommentsByPostId(@PathVariable("postId") Long postId) {
        try {
            List<Comment> comments = postService.getCommentsByPostId(postId);
            return ResponseEntity.ok(comments);
        } catch (PostNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
