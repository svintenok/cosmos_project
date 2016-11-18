package services.impl;

import models.Comment;
import repository.CommentRepository;
import repository.impl.CommentRepositoryImpl;
import services.CommentService;

import java.util.List;

/**
 * Author: Svintenok Kate
 * Date: 05.11.2016
 * Group: 11-501
 * Task: semester project
 */
public class CommentServiceImpl implements CommentService {
    CommentRepository commentRepository = new CommentRepositoryImpl();


    @Override
    public void addComment(Comment comment) {
        commentRepository.addComment(comment);
    }

    @Override
    public void removeComment(int id) {
        commentRepository.removeComment(id);
    }

    @Override
    public List<Comment> getCommentList(int news_id) {
        return commentRepository.getCommentsListByNews(news_id);
    }
}
