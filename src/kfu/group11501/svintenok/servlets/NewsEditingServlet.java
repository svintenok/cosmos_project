package kfu.group11501.svintenok.servlets;

import kfu.group11501.svintenok.models.News;
import kfu.group11501.svintenok.services.CommentService;
import kfu.group11501.svintenok.services.NewsService;
import kfu.group11501.svintenok.services.UserService;
import kfu.group11501.svintenok.services.impl.CommentServiceImpl;
import kfu.group11501.svintenok.services.impl.NewsServiceImpl;
import kfu.group11501.svintenok.services.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.HashMap;

import static kfu.group11501.svintenok.helpers.Helper.downloadPhoto;
import static kfu.group11501.svintenok.helpers.Helper.render;

/**
 * Author: Svintenok Kate
 * Date: 18.11.2016
 * Group: 11-501
 * Task: semester project
 */
@MultipartConfig
@WebServlet(name = "NewsEditingServlet")
public class NewsEditingServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    NewsService newsService= new NewsServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        int id = new Integer(request.getParameter("id"));
        News news = newsService.getNewsById(id);

        if(request.getParameter("delete") != null) {
            newsService.removeNews(id);
            response.sendRedirect("/news");
        }
        else {
            Part news_photo = request.getPart("news_photo");

            newsService.updateNews(new News(
                    news.getId(),
                    request.getParameter("title"),
                    request.getParameter("description"),
                    request.getParameter("text"),
                    news.getDateTimestamp()), news_photo);

            response.sendRedirect("/news?id=" + id);
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
                render(response, request, "news_creating.ftl", root);
            }
            else {
                response.sendError(404);
            }
        }
    }
}
