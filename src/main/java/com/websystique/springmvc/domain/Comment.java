package com.websystique.springmvc.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ufimtsev on 29.08.2017.
 */
@Entity
@Table(name = "dbo.comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long commentId;
    @Column(name = "comment_text")
    private String commentText;
    @Column(name = "create_date")
    @Temporal(value = TemporalType.DATE)
    private Date createDate;
    @OneToOne
    @JoinColumn(name = "comment_user_id")
    private User commentUser;

    public Comment() {
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", commentText='" + commentText + '\'' +
                ", createDate=" + createDate +
                ", commentUser=" + commentUser +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment = (Comment) o;

        if (commentId != null ? !commentId.equals(comment.commentId) : comment.commentId != null) return false;
        if (commentText != null ? !commentText.equals(comment.commentText) : comment.commentText != null) return false;
        if (createDate != null ? !createDate.equals(comment.createDate) : comment.createDate != null) return false;
        return commentUser != null ? commentUser.equals(comment.commentUser) : comment.commentUser == null;
    }

    @Override
    public int hashCode() {
        int result = commentId != null ? commentId.hashCode() : 0;
        result = 31 * result + (commentText != null ? commentText.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (commentUser != null ? commentUser.hashCode() : 0);
        return result;
    }
}
