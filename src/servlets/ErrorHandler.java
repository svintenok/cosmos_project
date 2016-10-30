package servlets;

import static helpers.Helper.render;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author: Svintenok Kate
 * Date: 30.10.2016
 * Group: 11-501
 * Task:
 */
@WebServlet(name = "servlets.ErrorHandler")
public class ErrorHandler extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        render(response, request, "error_handler.ftl", null);
    }
}