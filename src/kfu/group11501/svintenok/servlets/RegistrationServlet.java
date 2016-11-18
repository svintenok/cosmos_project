package kfu.group11501.svintenok.servlets;

import kfu.group11501.svintenok.models.User;
import kfu.group11501.svintenok.services.UserService;
import kfu.group11501.svintenok.services.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.regex.Pattern;

import static kfu.group11501.svintenok.helpers.Helper.getHash;
import static kfu.group11501.svintenok.helpers.Helper.render;

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

        Pattern passwordRegexp = Pattern.compile("[a-zA-Z0-9]{6,30}");
        Pattern loginRegexp = Pattern.compile("[\\w-]{1,30}");
        Pattern emailRegexp = Pattern.compile("[\\w-]+@[a-z0-9-]+\\.[a-z]{2,6}");

        request.setCharacterEncoding("utf-8");

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String passwordConf = request.getParameter("password_conf");
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String country = request.getParameter("country");
        Part photo = request.getPart("profile_photo");

        String error = null;

        if(userService.getUser(login) != null)
            error = "existing_login";
        else if(!loginRegexp.matcher(login).matches())
            error = "wrong_login";
        else if (!emailRegexp.matcher(email).matches())
            error = "wrong_email";
        else if(!passwordRegexp.matcher(password).matches())
            error = "wrong_password";
        else if (!password.equals(passwordConf))
            error = "wrong_conf_password";



        if(error == null) {
            userService.addUser(new User(login, getHash(password), email, name, country), photo);
            response.sendRedirect("/login");
        }
        else {
            response.encodeRedirectURL("utf-8");
            response.sendRedirect("/registration?error=" + error + "&login=" + login + "&email=" + email +
                    "&name=" + URLEncoder.encode(name, "utf-8")+ "&country=" + URLEncoder.encode(country, "utf-8"));
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HashMap<String, Object> root = new HashMap<>();
        root.put("error", request.getParameter("error"));
        root.put("login", request.getParameter("login"));
        root.put("name", request.getParameter("name"));
        root.put("email", request.getParameter("email"));
        root.put("country", request.getParameter("country"));

        render(response, request, "registration.ftl", root);
    }
}
