package servlets;

import services.CompanyInfoService;
import services.impl.CompanyInfoServiceImpl;
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
@WebServlet(name = "CompanyInfoServlet")
public class CompanyInfoServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    CompanyInfoService companyInfoService = new CompanyInfoServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HashMap<String, Object> root = new HashMap<>();
        String login = (String) request.getSession().getAttribute("current_user");
        if (login != null)
            root.put("current_user", userService.getUser(login));

        root.put("company_info", companyInfoService.getCompanyInfo());

        render(response, request, "company_info.ftl", root);
    }
}
