package kfu.group11501.svintenok.servlets;

import kfu.group11501.svintenok.services.UserService;
import kfu.group11501.svintenok.services.impl.UserServiceImpl;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author: Svintenok Kate
 * Date: 19.11.2016
 * Group: 11-501
 * Task: semester project
 */
@WebServlet(name = "LoginSearchServlet")
public class LoginSearchServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String jsonLogin = request.getParameter("jsonLogin");
            JSONObject resultJson = new JSONObject();
            if (userService.getUser(jsonLogin) != null) {
                resultJson.put("result", userService.getUser(jsonLogin).getLogin());
                response.setContentType("text/json");
                response.getWriter().println(resultJson.toString());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
