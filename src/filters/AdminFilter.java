package filters;

import services.UserService;
import services.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Author: Svintenok Kate
 * Date: 30.10.2016
 * Group: 11-501
 * Task: semester project
 */

public class AdminFilter implements javax.servlet.Filter {
    UserService userService = new UserServiceImpl();

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String login = (String) request.getSession().getAttribute("current_user");
        if( login != null && userService.getUser(login).getRole().getRole().equals("admin")) {
            chain.doFilter(request, response);
        }
        else {
            response.sendRedirect("/error_handler");
        }

    }

    public void init(FilterConfig config) throws ServletException {}

    public void destroy() {}

}
