package kfu.group11501.svintenok.servlets;

import kfu.group11501.svintenok.models.Comment;
import kfu.group11501.svintenok.models.News;
import kfu.group11501.svintenok.models.User;
import kfu.group11501.svintenok.services.*;
import kfu.group11501.svintenok.services.impl.CommentServiceImpl;
import kfu.group11501.svintenok.services.impl.NewsServiceImpl;
import kfu.group11501.svintenok.services.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

import static kfu.group11501.svintenok.helpers.Helper.render;

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
            Integer newsId = new Integer(request.getParameter("id"));

            if (request.getParameter("commentId") != null){
                Integer commentId = new Integer(request.getParameter("commentId"));
                commentService.removeComment(commentId);
            }
            else {
                User user = userService.getUser(login);
                Comment comment = new Comment(user.getId(), newsId, text);
                commentService.addComment(comment);
            }
            response.sendRedirect("/news?id=" + newsId);
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
            Integer page = 1;
            String pageParam = request.getParameter("page");
            if (pageParam == null || new Integer(pageParam) < 1)
                response.sendRedirect("/news?page=1");
            else
                page = new Integer(pageParam);
            root.put("page", page);
            root.put("limit", NewsServiceImpl.getNewsLimit());
            root.put("news_list", newsService.getNewsList(page));
            render(response, request, "news_list.ftl", root);
        }

    }
}
