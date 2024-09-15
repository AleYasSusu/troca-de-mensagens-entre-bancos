package br.com.aledev.commentservice.service;

import br.com.aledev.commentservice.model.Comment;
import br.com.aledev.commentservice.model.dto.CommentDTO;

import java.util.List;

public interface CommentService {
    Comment createComment(Comment comment);

    Comment getCommentById(Long commentId);

    List<Comment> getComments();

    void deleteComment(Long id);
}
