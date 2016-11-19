package kfu.group11501.svintenok.servlets;

import kfu.group11501.svintenok.models.Booking;
import kfu.group11501.svintenok.models.User;
import kfu.group11501.svintenok.services.BookingService;
import kfu.group11501.svintenok.services.impl.BookingServiceImpl;
import kfu.group11501.svintenok.services.UserService;
import kfu.group11501.svintenok.services.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

import static kfu.group11501.svintenok.helpers.Helper.render;

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
        String login =  (String) request.getSession().getAttribute("current_user");
        User user = userService.getUser(login);
        Integer tourId = new Integer(request.getParameter("tourId"));

        Booking booking = bookingService.getBoookingByUserAndTour(user.getId(), tourId);

        if (booking == null)
            bookingService.addBooking(user.getId(), tourId);
        else
            bookingService.removeBooking(booking.getId());

        response.sendRedirect("/bookings");
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
