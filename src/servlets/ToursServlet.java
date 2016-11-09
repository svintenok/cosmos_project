package servlets;

import models.Tour;
import services.TourService;
import services.TourServiceImpl;
import services.UserService;
import services.UserServiceImpl;

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
 * Date: 30.10.2016
 * Group: 11-501
 * Task: semester project
 */
@WebServlet(name = "ToursServlet")
public class ToursServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    TourService tourService = new TourServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HashMap<String, Object> root = new HashMap<>();
        String login = (String) request.getSession().getAttribute("current_user");
        root.put("current_user", userService.getUser(login));


        if (request.getParameter("id") != null){

            Integer id = new Integer(request.getParameter("id"));
            Tour tour = tourService.getTourById(id);
            if (tour != null) {
                root.put("tour", tour);
                render(response, request, "tour.ftl", root);
            }
            else {
                response.sendError(404);
            }
        }

        else {
            String sorting = request.getParameter("sorting");
            String backOrder = request.getParameter("back_order");
            String search = request.getParameter("search");
            root.put("sorting", sorting);
            root.put("back_order", backOrder);
            root.put("search", search);
            if (sorting == null)
                sorting = "date";
            if (backOrder != null)
                root.put("tours", tourService.getToursList(sorting, true, search));
            else
                root.put("tours", tourService.getToursList(sorting, false, search));
            render(response, request, "tours.ftl", root);
        }
    }
}
