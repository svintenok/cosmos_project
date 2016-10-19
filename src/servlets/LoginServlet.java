package servlets;

import singletons.DBSingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import static helpers.Helper.getHash;
import static helpers.Helper.render;


@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = request.getParameter("username").toLowerCase();
        String password = getHash(request.getParameter("password"));
        String remember = request.getParameter("remember");

        try {
            Connection con = DBSingleton.getConnection();
            PreparedStatement psmt = con.prepareStatement("select * from users where login=? and password=?");
            psmt.setString(1, username);
            psmt.setString(2, password);

            ResultSet rs = psmt.executeQuery();
            if (rs.next()) {
                if (remember != null) {
                    Cookie cookie = new Cookie("user", username);
                    cookie.setMaxAge(24 * 60 * 60);
                    response.addCookie(cookie);
                }

                session.setAttribute("current_user", username);
                response.sendRedirect("/news");
            }
            else {
                response.sendRedirect("/login?err=true&login=" + username);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HashMap<String, Object> root = new HashMap<>();
        root.put("login", request.getParameter("login"));
        root.put("err", request.getParameter("err"));

        render(response, request, "login.ftl", root);
    }
}
