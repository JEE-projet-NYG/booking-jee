package utils;

import config.Config;
import model.Reservation;
import model.Resource;
import model.ResourceType;
import model.User;
import service.ReservationService;
import service.ResourceService;
import service.UserService;
import service.impl.ReservationServiceImpl;
import service.impl.ResourceServiceImpl;
import service.impl.ResourceTypeServiceImpl;
import service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by ferrilata on 26/10/15.
 */
public class FormReservationUtils {

    public static HttpServletRequest getAvailableResource(HttpServletRequest request) {
        ResourceType resType = (new ResourceTypeServiceImpl()).list(request.getParameter("selType")).get(0);
        String dateMin = request.getParameter("dateMin");
        String dateMax = request.getParameter("dateMax");

        if (dateMin.compareTo(dateMax)<=0) {
            List<Resource> availableResources = (new ReservationServiceImpl()).listAvailableResources(resType, dateMin, dateMax);
            request.setAttribute("avRes", availableResources);
        } else {
            request.setAttribute("dateError", "La date de début doit être inférieure à la date de fin");
        }
        request.setAttribute("selType",resType.getName());
        request.setAttribute("dateMin",dateMin);
        request.setAttribute("dateMax",dateMax);

        return request;
    }

    public static void reserve(HttpServletRequest req) {
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm");
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
    }
}
