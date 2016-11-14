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

import static helpers.Helper.downloadPhoto;
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
    UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String country = request.getParameter("country");
        Part filePart = request.getPart("profile_photo");
        boolean hasPhoto = false;

        if(userService.getUser(login) == null) {

            if (filePart != null) {

                hasPhoto = true;
                downloadPhoto(filePart, "users_photo/" + login);
            }

            userService.addUser(new User(login, getHash(password), email, name, country, hasPhoto));
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
