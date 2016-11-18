package kfu.group11501.svintenok.servlets;

import kfu.group11501.svintenok.models.ForumTopic;
import kfu.group11501.svintenok.models.TopicMessage;
import kfu.group11501.svintenok.services.ForumService;
import kfu.group11501.svintenok.services.impl.ForumServiceImpl;
import kfu.group11501.svintenok.services.UserService;
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

        if (request.getParameter("id") != null) {
            Integer topicId = new Integer(request.getParameter("id"));

            if ( request.getParameter("messageId") != null){
                Integer messageId = new Integer(request.getParameter("messageId"));
                forumService.removeTopicMessage(messageId);
            }
            else {
                forumService.addTopicMessage(new TopicMessage(
                        topicId,
                        userService.getUser(login).getId(),
                        request.getParameter("message")
                ));
            }
            response.sendRedirect("/forum?id=" + topicId +"&page=" + forumService.getForumTopic(topicId, 1).getPagesCount());
        }
        else if (request.getParameter("topicId") != null){
            Integer topicId = new Integer(request.getParameter("topicId"));
            forumService.removeForumTopic(topicId);
            response.sendRedirect("/forum");
        }
        else {
            String name = request.getParameter("name");
            System.out.println(name);

            int id = forumService.addForumTopic(new ForumTopic(
                    name,
                    userService.getUser(login).getId()
            ));

            response.sendRedirect("/forum?id=" + id + "&page=1");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HashMap<String, Object> root = new HashMap<>();
        String login = (String) request.getSession().getAttribute("current_user");
        if (login != null)
            root.put("current_user", userService.getUser(login));


        if (request.getParameter("id") != null){
            Integer id = new Integer(request.getParameter("id"));
            Integer page = 1;
            String pageParam = request.getParameter("page");
            if (pageParam == null || new Integer(pageParam) < 1)
                response.sendRedirect("/forum?id=" + id + "&page=" + forumService.getForumTopic(id, 1).getPagesCount());
            else
                page = new Integer(pageParam);
            root.put("page", page);
            root.put("limit", ForumServiceImpl.getMessagesLimit());
            root.put("topic", forumService.getForumTopic(id, page));
            render(response, request, "forum.ftl", root);
        }

        else {
            root.put("users_forum_topics", forumService.getForumTopicsList(false));
            root.put("admin_forum_topics", forumService.getForumTopicsList(true));
            render(response, request, "forum_topics.ftl", root);
        }

    }


}
