package br.com.aledev.postservice.service.impl;

import br.com.aledev.postservice.exception.PostNotFoundException;
import br.com.aledev.postservice.model.Comment;
import br.com.aledev.postservice.model.Post;
import br.com.aledev.postservice.repository.PostRepository;
import br.com.aledev.postservice.service.PostService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;


    // Método para criar um post
    @Override
    public Post createPost(Post post) {
        return postRepository.save(post);

    }

    // Método para buscar um post por ID
    @Override
    public Post findPostById(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundException("Post not found with id: " + postId));
    }

    // Método para buscar todos os posts
    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public List<Comment> getCommentsByPostId(Long postId) {
        return postRepository.findById(postId).get().getComments();
    }
}
