package repository;

import models.Comment;

import java.util.List;

/**
 * Author: Svintenok Kate
 * Date: 03.11.2016
 * Group: 11-501
 * Task: semester project
 */
public interface CommentRepository {
    void addComment(Comment comment);
    void removeComment(int id);
    void updateComment(Comment comment);

    List<Comment> getCommentsListByNews(int newsId, int limit, int offset);
}
