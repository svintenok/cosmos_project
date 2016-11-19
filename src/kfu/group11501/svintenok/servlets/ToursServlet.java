package kfu.group11501.svintenok.servlets;

import kfu.group11501.svintenok.models.Booking;
import kfu.group11501.svintenok.models.Recall;
import kfu.group11501.svintenok.models.Tour;
import kfu.group11501.svintenok.models.User;
import kfu.group11501.svintenok.services.*;
import kfu.group11501.svintenok.services.impl.BookingServiceImpl;
import kfu.group11501.svintenok.services.impl.RecallServiceImpl;
import kfu.group11501.svintenok.services.impl.TourServiceImpl;
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
 * Date: 30.10.2016
 * Group: 11-501
 * Task: semester project
 */
@WebServlet(name = "ToursServlet")
public class ToursServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    TourService tourService = new TourServiceImpl();
    BookingService bookingService = new BookingServiceImpl();
    RecallService recallService = new RecallServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login =  (String) request.getSession().getAttribute("current_user");
        User user = userService.getUser(login);
        Integer tourId = new Integer(request.getParameter("id"));

        if (request.getParameter("recall_id") != null) {
            Integer recallId = new Integer(request.getParameter("recall_id"));
            recallService.removeRecall(recallId);
        }
        else {
            Recall recall = new Recall(
                    new Integer(request.getParameter("estimate")),
                    request.getParameter("recall"),
                    user.getId(),
                    new Integer(request.getParameter("departure_date")));
            recallService.addRecall(recall);
        }

        response.sendRedirect("/tours?id=" + tourId);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HashMap<String, Object> root = new HashMap<>();
        String login = (String) request.getSession().getAttribute("current_user");
        User user = null;
        if (login != null)
            user = userService.getUser(login);
            root.put("current_user", user);


        if (request.getParameter("id") != null){

            Integer id = new Integer(request.getParameter("id"));
            Tour tour = tourService.getTourById(id);
            if (tour != null) {
                if(user != null)
                    root.put("user_booking", bookingService.getBoookingByUserAndTour(user.getId(), id));

                root.put("tour", tour);
                render(response, request, "tour.ftl", root);
            }
            else {
                response.sendError(404);
            }
        }

        else {
            Integer page = 1;
            String pageParam = request.getParameter("page");
            if (pageParam == null || new Integer(pageParam) < 1)
                response.sendRedirect("/tours?page=1");
             else
                page = new Integer(pageParam);
            root.put("page", page);

            String sorting = request.getParameter("sorting");
            String backOrder = request.getParameter("back_order");
            String search = request.getParameter("search");
            root.put("sorting", sorting);
            root.put("limit", TourServiceImpl.getToursLimit());
            root.put("back_order", backOrder);
            root.put("search", search);
            if (sorting == null)
                sorting = "date";
            if (backOrder != null)
                root.put("tours", tourService.getToursList(sorting, true, search, page));
            else
                root.put("tours", tourService.getToursList(sorting, false, search, page));
            render(response, request, "tours.ftl", root);
        }
    }
}
