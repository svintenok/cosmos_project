package servlets;

import models.Comment;
import models.News;
import singletons.DBSingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static helpers.Helper.render;

/**
 * Author: Svintenok Kate
 * Date: 30.10.2016
 * Group: 11-501
 * Task: semester project
 */
@WebServlet(name = "NewsServlet")
public class NewsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        if (request.getParameter("id") != null) {

            String login = ((String) request.getSession().getAttribute("current_user")).toLowerCase();
            String comment = request.getParameter("comment");
            Integer news_id = new Integer(request.getParameter("id"));

            try {
                Connection con = DBSingleton.getConnection();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select id from users where login='" + login + "'");
                if (rs.next()) {
                    PreparedStatement psmt = con.prepareStatement("INSERT into comments(news_id, user_id, \"text\", \"date\") values(?, ?, ?, 'now')");
                    psmt.setInt(1, news_id);
                    psmt.setInt(2, rs.getInt("id"));
                    psmt.setString(3, comment);
                    psmt.executeUpdate();
                }

                response.sendRedirect("/news?id=" + news_id);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        HashMap<String, Object> root = new HashMap<>();
        String login = (String) request.getSession().getAttribute("current_user");
        String is_admin = (String) request.getSession().getAttribute("is_admin");
        root.put("login", login);
        root.put("is_admin", is_admin);

        try {

            Connection con = DBSingleton.getConnection();

            if (request.getParameter("id") != null){
                Integer id = new Integer(request.getParameter("id"));
                PreparedStatement psmt = con.prepareStatement("select * from news where id=?");
                psmt.setInt(1, id);
                ResultSet rs = psmt.executeQuery();

                if (rs.next()) {
                    News news = new News(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("short_description"),
                        rs.getString("text"),
                        rs.getTimestamp("date"));
                    root.put("news", news);
                }

                psmt = con.prepareStatement("select * from comments " +
                        "join (select id, login from users) senders on comments.user_id = senders.id " +
                        "where news_id=?");
                List<Comment> comments = new ArrayList<>();
                psmt.setInt(1, id);
                rs = psmt.executeQuery();
                while (rs.next()) {
                    Comment comment = new Comment(
                            rs.getInt("id"),
                            rs.getString("login"),
                            rs.getString("text"),
                            rs.getTimestamp("date"));
                    comments.add(comment);
                }

                root.put("comments", comments);
                render(response, request, "news.ftl", root);
            }

            else {
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from news ORDER BY \"date\"");
                List<News> news_list = new ArrayList<>();

                while (rs.next()) {
                    News news = new News(
                            rs.getInt("id"),
                            rs.getString("title"),
                            rs.getString("short_description"),
                            rs.getString("text"),
                            rs.getTimestamp("date"));
                    news_list.add(news);
                }

                root.put("news_list", news_list);
                render(response, request, "news_list.ftl", root);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        */
    }
}
