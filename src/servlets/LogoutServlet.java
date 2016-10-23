package servlets;

import singletons.DBSingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static helpers.Helper.getHash;


@WebServlet(name = "LogoutServlet")
public class LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = (String) request.getSession().getAttribute("current_user");

        try {
            Connection con = DBSingleton.getConnection();
            PreparedStatement psmt = con.prepareStatement("delete from tokens where login=?");
            psmt.setString(1, login);
            psmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.getSession().removeAttribute("current_user");
        Cookie cookie = new Cookie("user", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        response.sendRedirect("/news");
    }
}
