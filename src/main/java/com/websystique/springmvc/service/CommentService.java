package com.websystique.springmvc.service;


import com.websystique.springmvc.domain.Comment;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by ufimtsev on 29.08.2017.
 */
public interface CommentService {
    void addComment(Comment comment) throws SQLException;
    void updateComment(Long comment_id, Comment comment) throws SQLException;
    Comment getCommentById(Long comment_id) throws SQLException;
    Collection getAllComments() throws SQLException;
    void deleteComment(Comment comment) throws SQLException;
}
