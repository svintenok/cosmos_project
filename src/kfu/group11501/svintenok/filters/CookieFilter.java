package kfu.group11501.svintenok.filters;

import kfu.group11501.svintenok.models.Token;
import kfu.group11501.svintenok.models.User;
import kfu.group11501.svintenok.services.TokenService;
import kfu.group11501.svintenok.services.impl.TokenServiceImpl;
import kfu.group11501.svintenok.services.UserService;
import kfu.group11501.svintenok.services.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Author: Svintenok Kate
 * Date: 30.10.2016
 * Group: 11-501
 * Task: semester project
 */

public class CookieFilter implements javax.servlet.Filter {
    TokenService tokenService = new TokenServiceImpl();
    UserService userService = new UserServiceImpl();

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        if(request.getSession().getAttribute("current_user") == null) {
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("current_user")) {
                    Token token = tokenService.getToken(cookie.getValue());

                    if (token != null) {
                        User user = userService.getUser(token.getUserId());
                        HttpSession session = request.getSession();
                        session.setAttribute("current_user", user.getLogin());
                    }
                    break;
                }
            }
            }
        }

        chain.doFilter(request, response);

    }

    public void init(FilterConfig config) throws ServletException {}

    public void destroy() {}

}
