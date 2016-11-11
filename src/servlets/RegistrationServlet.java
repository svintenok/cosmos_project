package servlets;

import models.User;
import services.UserService;
import services.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.sql.*;
import java.util.HashMap;

import static helpers.Helper.getHash;
import static helpers.Helper.render;

/**
 * Author: Svintenok Kate
 * Date: 30.10.2016
 * Group: 11-501
 * Task: semester project
 */
@MultipartConfig
@WebServlet(name = "RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        String login = request.getParameter("login").toLowerCase();
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String country = request.getParameter("country");
        Part filePart = request.getPart("profile_photo");

        File file = new File("D:/repositories/cosmos_project_files/users_photo/" + login + ".jpg");
        file.createNewFile();
        FileOutputStream out = new FileOutputStream(file);
        InputStream filecontent = filePart.getInputStream();

        int read = 0;
        final byte[] bytes = new byte[1024];

        while ((read = filecontent.read(bytes)) != -1) {
            out.write(bytes, 0, read);
        }

        out.close();
        filecontent.close();


        UserService userService = new UserServiceImpl();

        User user = new User(login, getHash(password), email, name, country, false);


        if(userService.getUser(login) == null) {
            try {
                userService.addUser(user);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            response.sendRedirect("/login");

        }
        else {

            response.encodeRedirectURL("utf-8");
            response.sendRedirect("/registration?err=existing_login&login=" + login + "&email=" + email +
                    "&name=" + URLEncoder.encode(name, "utf-8")+ "&country=" + URLEncoder.encode(country, "utf-8"));
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        HashMap<String, Object> root = new HashMap<>();
        root.put("err", request.getParameter("err"));
        root.put("login", request.getParameter("login"));
        root.put("name", request.getParameter("name"));
        root.put("email", request.getParameter("email"));
        root.put("country", request.getParameter("country"));

        render(response, request, "registration.ftl", root);
    }
}
