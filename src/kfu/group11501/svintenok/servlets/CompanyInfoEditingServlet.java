package kfu.group11501.svintenok.servlets;

import kfu.group11501.svintenok.models.CompanyInfo;
import kfu.group11501.svintenok.services.CompanyInfoService;
import kfu.group11501.svintenok.services.UserService;
import kfu.group11501.svintenok.services.impl.CompanyInfoServiceImpl;
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
 * Date: 18.11.2016
 * Group: 11-501
 * Task: semester project
 */
@WebServlet(name = "CompanyInfoEditingServlet")
public class CompanyInfoEditingServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    CompanyInfoService companyInfoService = new CompanyInfoServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        companyInfoService.updateCompanyInfo(new CompanyInfo(
                    request.getParameter("text"),
                    request.getParameter("phone"),
                    request.getParameter("address"),
                    request.getParameter("email")));

        response.sendRedirect("/about");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HashMap<String, Object> root = new HashMap<>();
        String login = (String) request.getSession().getAttribute("current_user");
        root.put("current_user", userService.getUser(login));
        root.put("company_info", companyInfoService.getCompanyInfo());

        render(response, request, "company_info_editing.ftl", root);
    }
}
