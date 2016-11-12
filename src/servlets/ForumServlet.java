package servlets;

import models.ForumTopic;
import models.TopicMessage;
import models.User;
import services.ForumService;
import services.ForumServiceImpl;
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
 * Date: 11.11.2016
 * Group: 11-501
 * Task: semester project
 */
@WebServlet(name = "ForumServlet")
public class ForumServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    ForumService forumService = new ForumServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String login = ((String) request.getSession().getAttribute("current_user"));
        Integer id = new Integer(request.getParameter("id"));

        if (request.getParameter("id") != null) {
            String text = request.getParameter("text");
            forumService.addTopicMessage(new TopicMessage(
                    id,
                    userService.getUser(login).getId(),
                    request.getParameter("message")
            ));

            response.sendRedirect("/forum?id=" + id);
        }
        else {
            String name = request.getParameter("name");

            forumService.addForumTopic(new ForumTopic(
                    name,
                    userService.getUser(login).getId()
            ));

            response.sendRedirect("/forum?id=" + forumService.getForumTopic(name).getId());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HashMap<String, Object> root = new HashMap<>();
        String login = (String) request.getSession().getAttribute("current_user");
        if (login != null)
            root.put("current_user", userService.getUser(login));


        if (request.getParameter("id") != null){
            Integer id = new Integer(request.getParameter("id"));
            root.put("topic", forumService.getForumTopic(id));
            root.put("messages", forumService.getForumTopicMessages(id));
            render(response, request, "forum.ftl", root);
        }

        else {
            root.put("users_forum_topics", forumService.getForumTopicsList(false));
            root.put("admin_forum_topics", forumService.getForumTopicsList(true));
            render(response, request, "forum_topics.ftl", root);
        }

    }


}
