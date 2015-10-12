package controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("users")
public class FrontServlet extends HttpServlet {

    @PersistenceContext(unitName = "rootUnit")
    EntityManager em;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //req.setAttribute("users", ServiceUser.getUsers());
        //em.createQuery("SELECT usr from User usr").getResultList();
        req.setAttribute("users", em.createQuery("SELECT usr from User usr").getResultList());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}