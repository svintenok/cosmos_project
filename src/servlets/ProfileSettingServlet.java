package servlets;

import models.User;
import services.UserService;
import services.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.HashMap;

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
            String old_password = getHash(request.getParameter("old_password"));
            if(user.getPassword().equals(old_password)) {
                userService.updatePassword(user.getId(), getHash(request.getParameter("new_password")));
                response.sendRedirect("/profile?id=" + user.getId());
            }
            else
                response.sendRedirect("/profile_settings?err=wrong_password");
        }
        else {
            login = request.getParameter("login");
            String email = request.getParameter("email");
            String name = request.getParameter("name");
            String country = request.getParameter("country");
            boolean hasPhoto = user.getPhoto();

            if(login.equals(user.getLogin()) || userService.getUser(login) == null) {

                Part filePart = request.getPart("profile_photo");
                if (filePart != null) {

                    hasPhoto = true;
                    downloadPhoto(filePart, "users_photo/" + login);
                }

                userService.updateUser(new User(
                        user.getId(), login, user.getPassword(), email, name, country, hasPhoto, user.getRoleId()));
                response.sendRedirect("/profile?id=" + user.getId());
            }
            else {
                response.encodeRedirectURL("utf-8");
                response.sendRedirect("/profile_settings?err=existing_login&login=" + login + "&email=" + email +
                        "&name=" + URLEncoder.encode(name, "utf-8")+ "&country=" + URLEncoder.encode(country, "utf-8"));
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HashMap<String, Object> root = new HashMap<>();

        String login = (String) request.getSession().getAttribute("current_user");

        root.put("current_user", userService.getUser(login));
        render(response, request, "profile_setting.ftl", root);
    }
}
