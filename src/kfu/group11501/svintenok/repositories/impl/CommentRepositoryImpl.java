package kfu.group11501.svintenok.repositories.impl;

import kfu.group11501.svintenok.models.Comment;
import kfu.group11501.svintenok.models.User;
import kfu.group11501.svintenok.repositories.CommentRepository;
import kfu.group11501.svintenok.singletons.DBSingleton;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Svintenok Kate
 * Date: 03.11.2016
 * Group: 11-501
 * Task: semester project
 */
public class CommentRepositoryImpl implements CommentRepository {
    private Connection con = DBSingleton.getConnection();

    @Override
    public void addComment(Comment comment) {
        try {

            PreparedStatement psmt = con.prepareStatement("INSERT into comment(user_id, news_id, \"text\", \"date\") values(?, ?, ?, 'now')");
            psmt.setInt(1, comment.getUserId());
            psmt.setInt(2, comment.getNewsId());
            psmt.setString(3, comment.getText());
            psmt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeComment(int id) {
        try {

            PreparedStatement psmt = con.prepareStatement("delete from comment where id=?");
            psmt.setInt(1, id);
            psmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateComment(Comment comment) {

    }

    @Override
    public List<Comment> getCommentsListByNews(int newsId) {
        try {
            PreparedStatement psmt = con.prepareStatement("select * from comment where news_id=? ORDER BY \"date\"");

            List<Comment> comments = new ArrayList<>();
            psmt.setInt(1, newsId);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {
                User user = new UserRepositoryImpl().getUserById(rs.getInt("user_id"));
                Comment comment = new Comment(
                        rs.getInt("id"),
                        rs.getInt("news_id"),
                        rs.getString("text"),
                        rs.getTimestamp("date"),
                        user);
                comments.add(comment);
            }
            return comments;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
