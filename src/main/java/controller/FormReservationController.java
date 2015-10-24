package controller;

import config.Config;
import model.Reservation;
import model.Resource;
import model.User;
import service.ReservationService;
import service.ResourceService;
import service.UserService;
import service.impl.ReservationServiceImpl;
import service.impl.ResourceServiceImpl;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ferrilata on 24/10/15.
 */
@WebServlet("/form/reservation")
public class FormReservationController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SimpleDateFormat formater = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        Date dateStart=null;
        Date dateEnd=null;
        try {
            dateStart = formater.parse(req.getParameter("dateStart"));
            dateEnd = formater.parse(req.getParameter("dateEnd"));
        } catch (ParseException e) {
            //TODO exception
        }
        UserService userService = new UserServiceImpl();
        User borrower = userService.find((String) req.getSession().getAttribute(Config.LOGIN_ATTRIBUTE));

        ResourceService resourceService = new ResourceServiceImpl();
        Resource resource = resourceService.find(Long.parseLong(req.getParameter("resourceId")));

        Reservation reservation = new Reservation(dateStart, dateEnd, borrower, resource);

        ReservationService reservationService = new ReservationServiceImpl();
        reservationService.create(reservation);

        resp.sendRedirect("/"+Config.APP_NAME+"/myReservations");
    }
}
