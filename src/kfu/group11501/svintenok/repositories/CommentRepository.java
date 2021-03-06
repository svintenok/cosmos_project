package kfu.group11501.svintenok.repositories;

import kfu.group11501.svintenok.models.Comment;

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

    List<Comment> getCommentsListByNews(int newsId);
}
