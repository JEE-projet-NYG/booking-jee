package controller;

import config.Config;
import model.Reservation;
import model.User;
import service.ReservationService;
import service.ResourceService;
import service.ResourceTypeService;
import service.UserService;
import service.impl.ReservationServiceImpl;
import service.impl.ResourceServiceImpl;
import service.impl.ResourceTypeServiceImpl;
import service.impl.UserServiceImpl;
import utils.AuthenticationUtils;
import utils.FormReservationUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Servlet Dispatcher effectuant le routage vers la JSP cible
 */
@WebServlet("/" + Config.APP_NAME + "/*")
public class FrontServlet extends HttpServlet {

    private UserService su;
    private ResourceService sr;
    private ResourceTypeService srt;
    private ReservationService rs;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String pathInfo = req.getPathInfo();
        su = new UserServiceImpl();
        sr = new ResourceServiceImpl();
        srt = new ResourceTypeServiceImpl();
        rs = new ReservationServiceImpl();

        if (pathInfo != null) {
            switch (pathInfo) {
                case "/":
                    User user = su.find(req.getParameter("login"));
                    req.setAttribute("user", user);
                    req.setAttribute("page", "accueil.jsp");
                    break;
                case "/users":
                    req.setAttribute("users", su.listAll());
                    req.setAttribute("page", "users.jsp");
                    break;
                case "/resources":
                    req.setAttribute("users", su.listAll());
                    req.setAttribute("resources", sr.listAll());
                    req.setAttribute("resourceTypes", srt.listAll());
                    req.setAttribute("page", "resources.jsp");
                    break;
                case "/resourceTypes":
                    req.setAttribute("resourceTypes", srt.listAll());
                    req.setAttribute("page", "resourceTypes.jsp");
                    break;
                case "/reservations":
                    List<Reservation> reservations = listUsersByDate(req);
                    req.setAttribute("reservations", reservations);
                    req.setAttribute("page", "reservations.jsp");
                    break;
                case "/myReservations":
                    final String login = (String) req.getSession().getAttribute(Config.LOGIN_ATTRIBUTE);
                    List<Reservation> myReservations = rs.listByLogin(login);
                    req.setAttribute("reservations", myReservations);
                    req.setAttribute("page", "myReservations.jsp");
                    break;
                case "/form/login":
                    req.setAttribute("page", "login.jsp");
                    break;
                case "/logout":
                    req = AuthenticationUtils.logout(req);
                    req.setAttribute("page", "login.jsp");
                    break;
                case "/form/reservation":
                    req.setAttribute("resType", srt.listAll());
                    req.setAttribute("page", "formReservation.jsp");
                    break;
                case "/reservation":
                    req = FormReservationUtils.getAvailableResource(req);
                    req.setAttribute("resType", srt.listAll());
                    req.setAttribute("page", "formReservation.jsp");
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
        final String pathInfo = req.getPathInfo();
        if (pathInfo != null) {
            switch (pathInfo) {
                case "/login":
                    req = AuthenticationUtils.login(req);
                    if (AuthenticationUtils.userIsPresent(req.getSession())) {
                        req.setAttribute("page", "accueil.jsp");
                    } else {
                        req.setAttribute("loginError", "Login/Mot de passe incorrect");
                        req.setAttribute("page", "login.jsp");
                    }
                    break;
                case "/reservation":
                    FormReservationUtils.reserve(req);
                    final String login = (String) req.getSession().getAttribute(Config.LOGIN_ATTRIBUTE);
                    List<Reservation> myReservations = rs.listByLogin(login);
                    req.setAttribute("reservations", myReservations);
                    req.setAttribute("page", "myReservations.jsp");
                    break;
                case "/reservation/delete":
                    rs.delete(rs.find(Long.parseLong(req.getParameter("id"))));
                    break;
                default:
                    req.setAttribute("page", "404.jsp");
                    break;
            }
            req.getRequestDispatcher("/template.jsp").forward(req, resp);
        }
    }

    private List<Reservation> listUsersByDate(HttpServletRequest req) {
        String timePickerMin = req.getParameter("timePickerMin");
        String timePickerMax = req.getParameter("timePickerMax");

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        Date dateMin = null;
        if(timePickerMin != null) {
            try {
                dateMin = format.parse(timePickerMin);
            } catch (ParseException e) {
                // ne rien faire
            }
        }

        Date dateMax = null;
        if(timePickerMax != null) {
            try {
                dateMax = format.parse(timePickerMax);
            } catch (ParseException e) {
                // ne rien faire
            }
        }

        return rs.listInRange(dateMin, dateMax);
    }
}