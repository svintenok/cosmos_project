package kfu.group11501.svintenok.servlets;

import kfu.group11501.svintenok.models.Interval;
import kfu.group11501.svintenok.models.Tour;
import kfu.group11501.svintenok.services.TourService;
import kfu.group11501.svintenok.services.impl.TourServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;


import static kfu.group11501.svintenok.helpers.Helper.currentDate;
import static kfu.group11501.svintenok.helpers.Helper.render;

/**
 * Author: Svintenok Kate
 * Date: 14.11.2016
 * Group: 11-501
 * Task: semester project
 */
@MultipartConfig
@WebServlet(name = "TourCreatingServlet")
public class TourCreatingServlet extends HttpServlet {
    TourService tourService = new TourServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        Interval interval = null;

        if (request.getParameter("not-repeat") == null) {
            int yearsInterval = new Integer(request.getParameter("years_interval"));
            int monthsInterval = new Integer(request.getParameter("months_interval"));
            if (monthsInterval > 0 || yearsInterval > 0)
                interval = new Interval(yearsInterval, monthsInterval);
        }

        Part tourPhoto = request.getPart("tour_photo");

        Tour tour = new Tour(
                request.getParameter("title"),
                request.getParameter("place"),
                request.getParameter("rocket"),
                request.getParameter("description"),
                interval,
                new Integer(request.getParameter("seats_number")),
                new Integer(request.getParameter("cost")));

        int id = tourService.addTour(tour, request.getParameter("date"), tourPhoto);

        response.sendRedirect("/tours?id=" + id);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HashMap<String, Object> root = new HashMap<>();
        Date currentDate = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyy-MM-dd");
        root.put("current_date", format.format(currentDate));
        render(response, request, "tour_creating.ftl", root);
    }
}
