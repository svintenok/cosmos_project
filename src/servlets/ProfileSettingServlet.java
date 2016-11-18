package servlets;

import models.User;
import services.UserService;
import services.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.regex.Pattern;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.sym.error;
import static helpers.Helper.downloadPhoto;
import static helpers.Helper.getHash;
import static helpers.Helper.render;

/**
 * Author: Svintenok Kate
 * Date: 11.11.2016
 * Group: 11-501
 * Task: semester project
 */
@MultipartConfig
@WebServlet(name = "ProfileSettingServlet")
public class ProfileSettingServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String login = (String) request.getSession().getAttribute("current_user");
        User user = userService.getUser(login);

        if(request.getParameter("password_change") != null) {
            Pattern passwordRegexp = Pattern.compile("[a-zA-Z0-9]{6,30}");

            String old_password = getHash(request.getParameter("old_password"));
            String password = request.getParameter("password");
            String passwordConf = request.getParameter("password_conf");


            String passwordError = null;
            if(!user.getPassword().equals(old_password))
                passwordError = "wrong_old_password";
            else if(!passwordRegexp.matcher(password).matches())
                passwordError = "wrong_password";
            else if (!password.equals(passwordConf))
                passwordError = "wrong_conf_password";

            if (passwordError == null){
                userService.updatePassword(user.getId(), getHash(password));
                response.sendRedirect("/profile?id=" + user.getId());
            }
            else
                response.sendRedirect("/settings?password_error=" + passwordError);
        }
        else {
            Pattern emailRegexp = Pattern.compile("[\\w-]+@[a-z0-9-]+\\.[a-z]{2,6}");

            String email = request.getParameter("email");
            String name = request.getParameter("name");
            String country = request.getParameter("country");
            Part photo = request.getPart("profile_photo");

            String error = null;

            if (!emailRegexp.matcher(email).matches())
                error = "wrong_email";


            if (error == null){
                user = new User(user.getId(), user.getLogin(), user.getPassword(), email, name, country, user.getPhoto(), user.getRoleId());
                userService.updateUser(user, photo);

                response.sendRedirect("/profile?id=" + user.getId());
            }
            else {
                response.encodeRedirectURL("utf-8");
                response.sendRedirect("/settings?error=" + error + "&login=" + login + "&email=" + email +
                        "&name=" + URLEncoder.encode(name, "utf-8") + "&country=" + URLEncoder.encode(country, "utf-8"));
            }

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HashMap<String, Object> root = new HashMap<>();

        String login = (String) request.getSession().getAttribute("current_user");

        root.put("error", request.getParameter("error"));
        root.put("password_error", request.getParameter("password_error"));
        root.put("current_user", userService.getUser(login));
        render(response, request, "profile_setting.ftl", root);
    }
}
