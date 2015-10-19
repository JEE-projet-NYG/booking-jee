package controller;

import config.Config;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/" + Config.APP_NAME + "/*")
public class FrontServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
/*
        // Test code at root context
        resp.setContentType("text/html");

        UserService su = new UserServiceImpl();
        for (User u : su.listAll()) {
            resp.getOutputStream().println("<p>" + u.toString() + "</p>");
        }*/

        //**************************************************************//

        final String pathInfo = req.getPathInfo();
        final UserService su = new UserServiceImpl();
        if (pathInfo != null) {
            switch (pathInfo) {
                case "/":
                    req.setAttribute("page", "accueil.jsp");
                    //req.setAttribute("info", Service.getInfoClub());
                    break;
                case "/users":
                    req.setAttribute("users", su.listAll());
                    req.setAttribute("page", "users.jsp");
                    break;
                case "/login":
                    req.setAttribute("page", "login.jsp");
                    break;
                default:
                    req.setAttribute("page", "404.jsp");
                    break;
            }
            req.getRequestDispatcher("/template.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}