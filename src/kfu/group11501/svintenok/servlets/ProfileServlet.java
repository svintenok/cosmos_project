package kfu.group11501.svintenok.servlets;

import kfu.group11501.svintenok.models.Booking;
import kfu.group11501.svintenok.models.Recall;
import kfu.group11501.svintenok.models.User;
import kfu.group11501.svintenok.services.*;
import kfu.group11501.svintenok.services.impl.BookingServiceImpl;
import kfu.group11501.svintenok.services.impl.RecallServiceImpl;
import kfu.group11501.svintenok.services.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static kfu.group11501.svintenok.helpers.Helper.render;

/**
 * Author: Svintenok Kate
 * Date: 30.10.2016
 * Group: 11-501
 * Task: semester project
 */
@WebServlet(name = "ProfileServlet")
public class ProfileServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    BookingService bookingService = new BookingServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HashMap<String, Object> root = new HashMap<>();
        String login = (String) request.getSession().getAttribute("current_user");
        if (login != null)
            root.put("current_user", userService.getUser(login));

        if (request.getParameter("id") != null){

            Integer id = new Integer(request.getParameter("id"));
            User user = userService.getUser(id);
            if (user != null) {
                root.put("user", user);
                List<Booking> bookings = bookingService.getTravelsListByUser(id);
                root.put("travels", bookings);
                root.put("travels_number", bookingService.getTravelsCountByUser(id));
                render(response, request, "profile.ftl", root);
            }
            else {
                response.sendError(404);
            }
        }
        else {
            response.sendError(404);
        }
    }
}
