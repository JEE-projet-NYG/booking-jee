package controller;

import model.User;
import service.ServiceUser;
import service.impl.ServiceUserImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class FrontServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Test code at root context
        resp.setContentType("text/html");

        ServiceUser su = new ServiceUserImpl();
        for (User u : su.listAll()) {
            resp.getOutputStream().println("<p>" + u.toString() + "</p>");
        }

        //**************************************************************//

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}