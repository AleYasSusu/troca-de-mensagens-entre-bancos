package br.com.aledev.postservice.service;

import br.com.aledev.postservice.model.Comment;
import br.com.aledev.postservice.model.Post;

import java.util.List;

public interface PostService {

    Post createPost(Post postDto);

    Post findPostById(Long postId);

    List<Post> getAllPosts();

    List<Comment> getCommentsByPostId(Long postId);
}
