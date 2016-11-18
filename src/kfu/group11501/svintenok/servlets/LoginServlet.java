package kfu.group11501.svintenok.servlets;

import kfu.group11501.svintenok.models.Token;
import kfu.group11501.svintenok.models.User;
import kfu.group11501.svintenok.services.TokenService;
import kfu.group11501.svintenok.services.impl.TokenServiceImpl;
import kfu.group11501.svintenok.services.UserService;
import kfu.group11501.svintenok.services.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

import static kfu.group11501.svintenok.helpers.Helper.getHash;
import static kfu.group11501.svintenok.helpers.Helper.render;

/**
 * Author: Svintenok Kate
 * Date: 30.10.2016
 * Group: 11-501
 * Task: semester project
 */
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    TokenService tokenService = new TokenServiceImpl();
    UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String login = request.getParameter("login").toLowerCase();
        String password = getHash(request.getParameter("password"));
        String remember = request.getParameter("remember");

        User user = userService.getUser(login, password);
        if (user != null) {
            if (remember != null) {
                String tokenString = getHash(new Date().toString());

                Token token = new Token(user.getId(), tokenString);
                tokenService.addToken(token);

                Cookie cookie = new Cookie("current_user", tokenString);
                cookie.setMaxAge(24 * 60 * 60);
                response.addCookie(cookie);
            }

            session.setAttribute("current_user", login);
            response.sendRedirect("/profile?id=" + user.getId());
        }
        else {
            response.sendRedirect("/login?err=wrong_password_or_login&login=" + login);

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HashMap<String, Object> root = new HashMap<>();
        root.put("login", request.getParameter("login"));
        root.put("err", request.getParameter("err"));

        render(response, request, "login.ftl", root);
    }
}
