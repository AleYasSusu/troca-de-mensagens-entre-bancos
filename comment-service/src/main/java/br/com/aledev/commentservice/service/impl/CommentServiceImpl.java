package br.com.aledev.commentservice.service.impl;

import br.com.aledev.commentservice.exception.CommentNotFoundException;
import br.com.aledev.commentservice.model.Comment;
import br.com.aledev.commentservice.model.dto.CommentDTO;
import br.com.aledev.commentservice.repository.CommentRepository;
import br.com.aledev.commentservice.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {


    private final CommentRepository commentRepository;
    private final ModelMapper modelMapper;

    @Override
    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);

    }

    @Override
    public Comment getCommentById(Long commentId) {
        return commentRepository.findById(commentId)
                .orElseThrow(() -> new CommentNotFoundException("Comment not found with id: " + commentId));
    }

    @Override
    public List<Comment> getComments() {
        List<Comment> comments = commentRepository.findAll();
        return comments;

    }

    @Override
    public void deleteComment(Long id) {
        if (commentRepository.existsById(id)) {
            commentRepository.deleteById(id);
        } else {
            throw new CommentNotFoundException("Comment not found with id: " + id);
        }
    }
}
