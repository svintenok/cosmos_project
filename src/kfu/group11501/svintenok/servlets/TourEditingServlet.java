package kfu.group11501.svintenok.servlets;

import kfu.group11501.svintenok.models.Interval;
import kfu.group11501.svintenok.models.Tour;
import kfu.group11501.svintenok.models.User;
import kfu.group11501.svintenok.services.TourService;
import kfu.group11501.svintenok.services.UserService;
import kfu.group11501.svintenok.services.impl.TourServiceImpl;
import kfu.group11501.svintenok.services.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.HashMap;

import static kfu.group11501.svintenok.helpers.Helper.downloadPhoto;
import static kfu.group11501.svintenok.helpers.Helper.render;

/**
 * Author: Svintenok Kate
 * Date: 18.11.2016
 * Group: 11-501
 * Task: semester project
 */
@MultipartConfig
@WebServlet(name = "TourEditingServlet")
public class TourEditingServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    TourService tourService = new TourServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int id = new Integer(request.getParameter("id"));
        Tour tour = tourService.getTourById(id);
        Part tourPhoto = request.getPart("tour_photo");
        Interval interval = null;

        if (request.getParameter("not-repeat") == null)
            interval = new Interval(new Integer(request.getParameter("years_interval")),
                    new Integer(request.getParameter("months_interval")));


        tourService.updateTour(new Tour(
                        tour.getId(),
                        request.getParameter("title"),
                        request.getParameter("place"),
                        request.getParameter("rocket"),
                        request.getParameter("description"),
                        tour.getDepartureDateId(),
                        interval,
                        new Integer(request.getParameter("seats_number")),
                        new Integer(request.getParameter("cost"))
                ), tourPhoto);


        response.sendRedirect("/tours?id=" + id);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HashMap<String, Object> root = new HashMap<>();
        String login = (String) request.getSession().getAttribute("current_user");
        User user = userService.getUser(login);
        root.put("current_user", user);

        if (request.getParameter("id") != null){

            Integer id = new Integer(request.getParameter("id"));
            Tour tour = tourService.getTourById(id);
            if (tour != null) {
                root.put("tour", tour);
                render(response, request, "tour_creating.ftl", root);
            }
            else {
                response.sendError(404);
            }
        }
    }


}
