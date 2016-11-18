package kfu.group11501.svintenok.servlets;

import kfu.group11501.svintenok.models.Tour;
import org.postgresql.util.PGInterval;
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

import java.sql.SQLException;

import static kfu.group11501.svintenok.helpers.Helper.downloadPhoto;
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

        PGInterval interval = null;
        try {
            interval = new PGInterval("0 years " + request.getParameter("interval") + " mons 0 days 0 hours 0 mins 0.00 secs");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        int id = tourService.addTour(new Tour(
                request.getParameter("title"),
                request.getParameter("place"),
                request.getParameter("rocket"),
                request.getParameter("description"),
                interval,
                new Integer(request.getParameter("seats_number")),
                new Integer(request.getParameter("cost"))
        ),
                request.getParameter("date"));



        Part filePart = request.getPart("tour_photo");
        downloadPhoto(filePart, "tours_photo/" + id);

        response.sendRedirect("/tours?id=" + id);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        render(response, request, "tour_creating.ftl", null);
    }
}
