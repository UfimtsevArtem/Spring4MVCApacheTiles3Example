package com.websystique.springmvc.service;

import com.websystique.springmvc.dao.CommentDao;
import com.websystique.springmvc.domain.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by ufimtsev on 29.08.2017.
 */
@Service
public class CommentServiceImp implements CommentService {

    private final CommentDao commentDao;

    @Autowired
    public CommentServiceImp(CommentDao commentDao) {
        this.commentDao = commentDao;
    }
    @Transactional
    @Override
    public void addComment(Comment comment) throws SQLException {
        commentDao.addComment(comment);
    }
    @Transactional
    @Override
    public void updateComment(Long comment_id, Comment comment) throws SQLException {
        commentDao.updateComment(comment_id, comment);
    }
    @Transactional(readOnly = true)
    @Override
    public Comment getCommentById(Long comment_id) throws SQLException {
        return commentDao.getCommentById(comment_id);
    }
    @Transactional(readOnly = true)
    @Override
    public Collection getAllComments() throws SQLException {
        return commentDao.getAllComments();
    }
    @Transactional
    @Override
    public void deleteComment(Comment comment) throws SQLException {
        commentDao.deleteComment(comment);
    }
}
