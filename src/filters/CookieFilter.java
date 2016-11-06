package filters;

import models.Token;
import models.User;
import repository.TokenRepository;
import services.TokenService;
import services.TokenServiceImpl;
import services.UserService;
import services.UserServiceImpl;
import singletons.DBSingleton;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Author: Svintenok Kate
 * Date: 30.10.2016
 * Group: 11-501
 * Task: semester project
 */
@WebFilter(filterName = "filters.CookieFilter")
public class CookieFilter implements javax.servlet.Filter {
    TokenService tokenService = new TokenServiceImpl();
    UserService userService = new UserServiceImpl();

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        if(request.getSession().getAttribute("current_user") == null) {
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")) {
                    Token token = tokenService.getToken(cookie.getValue());

                    if (token != null) {
                        User user = userService.getUser(token.getUser_id());
                        HttpSession session = request.getSession();
                        session.setAttribute("current_user", user.getLogin());
                    }
                    break;
                }
            }
        }

        chain.doFilter(request, response);

    }

    public void init(FilterConfig config) throws ServletException {}

    public void destroy() {}

}
