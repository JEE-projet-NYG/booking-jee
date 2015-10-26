package service.impl;

import dao.ReservationDao;
import model.Reservation;
import model.Resource;
import model.ResourceType;
import service.ReservationService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Implementation of {ReservationService}
 */
public class ReservationServiceImpl implements ReservationService {
    @Override
    public Reservation find(final Long id) {
        return ReservationDao.getDAO().find(id);
    }

    @Override
    public void create(Reservation r) {
        ReservationDao.getDAO().create(r);
    }

    @Override
    public void delete(Reservation r) {
        ReservationDao.getDAO().delete(r);
    }

    @Override
    public void update(Reservation r) {
        ReservationDao.getDAO().update(r);
    }

    @Override
    public List<Reservation> listAll() {
        return ReservationDao.getDAO().listAll();
    }

    @Override
    public List<Reservation> listInRange(Date dateMin, Date dateMax) { return ReservationDao.getDAO().listInRange(dateMin, dateMax); }

    @Override
    public List<Reservation> listInRange(Resource resource, Date dateMin, Date dateMax) { return ReservationDao.getDAO().listInRange(resource, dateMin, dateMax); }

    @Override
    public List<Reservation> listByLogin(String login) {
        return ReservationDao.getDAO().listByLogin(login);
    }

    @Override
    public boolean canBook(Resource resource, Date dateStart, Date dateEnd) {
        return ReservationDao.getDAO().listInRange(resource, dateStart, dateEnd).isEmpty();
    }

    @Override
    public List<Resource> listAvailableResources(ResourceType resourceType, Date dateMin, Date dateMax) {
        return ReservationDao.getDAO().listAvailableResources(resourceType, dateMin, dateMax);
    }

    @Override
    public List<Resource> listAvailableResources(ResourceType resourceType, String dateMin, String dateMax) {
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date dateStart=null;
        Date dateEnd=null;
        try {
            dateStart = formater.parse(dateMin);
            dateEnd = formater.parse(dateMax);
        } catch (ParseException e) {
            //TODO exception
        }
        return ReservationDao.getDAO().listAvailableResources(resourceType, dateStart, dateEnd);
    }
}
