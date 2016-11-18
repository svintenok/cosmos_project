package services;

import models.Comment;

import java.util.List;

/**
 * Author: Svintenok Kate
 * Date: 05.11.2016
 * Group: 11-501
 * Task: semester project
 */
public interface CommentService {

    void addComment(Comment comment);
    void removeComment(int id);
    List<Comment>  getCommentList(int news_id);
}
