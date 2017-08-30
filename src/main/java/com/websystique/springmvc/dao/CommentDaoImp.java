package com.websystique.springmvc.dao;

import com.websystique.springmvc.domain.Comment;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by ufimtsev on 29.08.2017.
 */
@Repository
public class CommentDaoImp implements CommentDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public CommentDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addComment(Comment comment) throws SQLException {
        sessionFactory.getCurrentSession().save(comment);
    }

    @Override
    public void updateComment(Long comment_id, Comment comment) throws SQLException {
        sessionFactory.getCurrentSession().update(comment);
    }

    @Override
    public Comment getCommentById(Long comment_id) throws SQLException {
        return sessionFactory.getCurrentSession().load(Comment.class, comment_id);
    }

    @Override
    public Collection getAllComments() throws SQLException {
        @SuppressWarnings("unchecked")
        TypedQuery<Comment> query=sessionFactory.getCurrentSession().createQuery("from Comment");
        return query.getResultList();
    }

    @Override
    public void deleteComment(Comment comment) throws SQLException {
        sessionFactory.getCurrentSession().delete(comment);
    }
}
