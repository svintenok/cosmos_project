package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Author: Svintenok Kate
 * Date: 30.10.2016
 * Group: 11-501
 * Task:
 */
@WebFilter(filterName = "filters.AuthFilter")
public class AdminFilter implements javax.servlet.Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        if((request.getSession().getAttribute("current_user") == null) && (request.getSession().getAttribute("is_admin").equals(true))) {

            chain.doFilter(request, response);
        }
        else {
            response.sendRedirect("/error_handler");
        }

    }

    public void init(FilterConfig config) throws ServletException {}

    public void destroy() {}

}
