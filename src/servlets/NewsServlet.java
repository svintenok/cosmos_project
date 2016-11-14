package servlets;

import models.Comment;
import models.News;
import models.User;
import services.*;
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
    UserService userService = new UserServiceImpl();
    CommentService commentService = new CommentServiceImpl();
    NewsService newsService= new NewsServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        if (request.getParameter("id") != null) {

            String login = (String) request.getSession().getAttribute("current_user");
            String text = request.getParameter("comment");
            Integer news_id = new Integer(request.getParameter("id"));

            User user = userService.getUser(login);
            Comment comment = new Comment(user.getId(), news_id, text);
            commentService.addComment(comment);

            response.sendRedirect("/news?id=" + news_id);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HashMap<String, Object> root = new HashMap<>();
        String login = (String) request.getSession().getAttribute("current_user");
        if (login != null)
            root.put("current_user", userService.getUser(login));


        if (request.getParameter("id") != null){

            Integer id = new Integer(request.getParameter("id"));
            News news = newsService.getNewsById(id);
            if (news != null) {
                root.put("news", news);
                root.put("comments", new CommentServiceImpl().getCommentList(id));
                render(response, request, "news.ftl", root);
            }
            else {
                response.sendError(404);
            }
        }

        else {

            root.put("news_list", newsService.getNewsList());
            render(response, request, "news_list.ftl", root);
        }

    }
}
