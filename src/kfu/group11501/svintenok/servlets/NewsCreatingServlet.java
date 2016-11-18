package kfu.group11501.svintenok.servlets;

import kfu.group11501.svintenok.models.News;
import kfu.group11501.svintenok.services.NewsService;
import kfu.group11501.svintenok.services.impl.NewsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

import static kfu.group11501.svintenok.helpers.Helper.downloadPhoto;
import static kfu.group11501.svintenok.helpers.Helper.render;

/**
 * Author: Svintenok Kate
 * Date: 30.10.2016
 * Group: 11-501
 * Task: semester project
 */
@MultipartConfig
@WebServlet(name = "NewsCreatingServlet")
public class NewsCreatingServlet extends HttpServlet {
    NewsService newsService = new NewsServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        int id = newsService.addNews(new News(
                    request.getParameter("title"),
                    request.getParameter("description"),
                    request.getParameter("text")));

        Part filePart = request.getPart("news_photo");
        downloadPhoto(filePart, "news_photo/" + id);

        response.sendRedirect("/news?id=" + id);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        render(response, request, "news_creating.ftl", null);
    }
}
