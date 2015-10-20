package controller;

import config.Config;
import model.Ressource;
import service.RessourceService;
import service.UserService;
import service.impl.RessourceServiceImpl;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet Dispatcher effectuant le routage vers la JSP cible
 */
@WebServlet("/" + Config.APP_NAME + "/*")
public class FrontServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String pathInfo = req.getPathInfo();
        final UserService su = new UserServiceImpl();
        final RessourceService sr = new RessourceServiceImpl();
        if (pathInfo != null) {
            switch (pathInfo) {
                case "/":
                    req.setAttribute("page", "accueil.jsp");
                    break;
                case "/users":
                    req.setAttribute("users", su.listAll());
                    req.setAttribute("page", "users.jsp");
                    break;
                case "/ressources":
                    req.setAttribute("ressources", sr.listAll());
                    req.setAttribute("page", "ressources.jsp");
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