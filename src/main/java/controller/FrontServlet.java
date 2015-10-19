package controller;

import service.ServiceUser;
import service.impl.ServiceUserImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/action/*")
public class FrontServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
/*
        // Test code at root context
        resp.setContentType("text/html");

        ServiceUser su = new ServiceUserImpl();
        for (User u : su.listAll()) {
            resp.getOutputStream().println("<p>" + u.toString() + "</p>");
        }*/

        //**************************************************************//

        final String pathInfo = req.getPathInfo();
        final ServiceUser su = new ServiceUserImpl();
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

            }
            req.getRequestDispatcher("/template.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}