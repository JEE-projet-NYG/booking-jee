package controller;

import config.Config;
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
        resp.getOutputStream().println("<h1>Yo " +
                Config.em.toString() +
                "</h1>");

        User u1 = new User();
        u1.setAdmin(Boolean.TRUE);
        u1.setFirstname("guillaume");
        u1.setLastname("pouilloux");
        u1.setLogin("gpouilloux");
        u1.setMailAddress("gui.pouilloux@gmail.com");
        u1.setPassword("azerty");
        u1.setPhoneNumber("0102030405");

        ServiceUser su = new ServiceUserImpl();
        su.create(u1);

        User uFind = su.find(1L);
        resp.getOutputStream().println(uFind != null ? uFind.toString() : "");
        //**************************************************************//

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}