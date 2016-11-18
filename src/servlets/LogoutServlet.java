package servlets;

import services.TokenService;
import services.impl.TokenServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author: Svintenok Kate
 * Date: 30.10.2016
 * Group: 11-501
 * Task: semester project
 */
@WebServlet(name = "LogoutServlet")
public class LogoutServlet extends HttpServlet {
    TokenService tokenService = new TokenServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = (String) request.getSession().getAttribute("current_user");

        TokenService tokenService = new TokenServiceImpl();
        tokenService.removeToken(login);

        request.getSession().removeAttribute("current_user");
        Cookie cookie = new Cookie("current_user", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        response.sendRedirect("/news");
    }
}
