package servlets;

import singletons.DBSingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;
import java.util.HashMap;

import static helpers.Helper.getHash;
import static helpers.Helper.render;


@WebServlet(name = "RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login").toLowerCase();
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String country = request.getParameter("country");

        if(password.equals(null) || login.equals(null)){
            response.sendRedirect("/registration?err=null_login_or_password&login=" + login + "&email=" + email +
                    "&name=" + name + "&country=" + country);
        }

        try {
            Connection con = DBSingleton.getConnection();

            PreparedStatement psmt = con.prepareStatement("select login from users where login=?");
            psmt.setString(1, login);
            ResultSet rs = psmt.executeQuery();
            if(rs.next())
                response.sendRedirect("/registration?err=existing_login&login=" + login + "&email=" + email +
                "&name=" + name + "&country=" + country);

            psmt = con.prepareStatement("insert into users(login, password, email, \"name\", country) values(?,?,?,?,?)");
            psmt.setString(1, login);
            psmt.setString(2, getHash(password));
            psmt.setString(3, email);
            psmt.setString(4, name);
            psmt.setString(5, country);

            psmt.executeUpdate();
            response.sendRedirect("/login");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HashMap<String, Object> root = new HashMap<>();
        root.put("err", request.getParameter("err"));
        root.put("login", request.getParameter("login"));
        root.put("name", request.getParameter("name"));
        root.put("email", request.getParameter("email"));
        root.put("country", request.getParameter("country"));
        render(response, request, "registration.ftl", root);
    }
}
