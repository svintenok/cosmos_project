package servlets;

import models.User;
import services.BookingService;
import services.impl.BookingServiceImpl;
import services.UserService;
import services.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

import static helpers.Helper.render;

/**
 * Author: Svintenok Kate
 * Date: 11.11.2016
 * Group: 11-501
 * Task: semester project
 */
@WebServlet(name = "BookingsServlet")
public class BookingsServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    BookingService bookingService = new BookingServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HashMap<String, Object> root = new HashMap<>();
        String login = (String) request.getSession().getAttribute("current_user");
        User user = userService.getUser(login);
        root.put("current_user", user);

        root.put("bookings", bookingService.getBookingListByUser(user.getId()));
        render(response, request, "bookings.ftl", root);
    }
}
