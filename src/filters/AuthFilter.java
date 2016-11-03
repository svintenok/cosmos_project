package filters;

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
@WebFilter(filterName = "filters.AuthFilter")
public class AuthFilter implements javax.servlet.Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        if(request.getSession().getAttribute("current_user") == null) {
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")) {

                    try {
                        Connection con = DBSingleton.getConnection();
                        PreparedStatement psmt =  con.prepareStatement(
                                "select * from (select * from tokens where token= ? ) tokens " +
                                        "join users on tokens.login=user.login");
                        psmt.setString(1, cookie.getValue());
                        ResultSet rs = psmt.executeQuery();
                        if (rs.next()) {
                            HttpSession session = request.getSession();
                            session.setAttribute("current_user", rs.getString("login"));
                            if(rs.getBoolean("is_admin"))
                                session.setAttribute("admin", "true");
                        }

                        break;

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                }
            }
        }

        chain.doFilter(request, response);

    }

    public void init(FilterConfig config) throws ServletException {}

    public void destroy() {}

}
