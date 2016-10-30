package servlets;

import singletons.DBSingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

import static helpers.Helper.render;

/**
 * Author: Svintenok Kate
 * Date: 30.10.2016
 * Group: 11-501
 * Task:
 */
@WebServlet(name = "NewsCreatingServlet")
public class NewsCreatingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String text = request.getParameter("text");

        try {
            Connection con = DBSingleton.getConnection();

            PreparedStatement psmt = con.prepareStatement("insert into news(title, short_description, \"text\", \"date\") values(?,?,?,'now')");
            psmt.setString(1, title);
            psmt.setString(2, description);
            psmt.setString(3, text);

            psmt.executeUpdate();
            response.sendRedirect("/news");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HashMap<String, Object> root = new HashMap<>();
        String login = (String) request.getSession().getAttribute("current_user");
        root.put("login", login);
        render(response, request, "news_creating.ftl", root);
    }
}
