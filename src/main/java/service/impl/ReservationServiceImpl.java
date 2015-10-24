package service.impl;

import dao.ReservationDao;
import model.Reservation;
import service.ReservationService;

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
    public List<Reservation> listByLogin(String login) {
        return ReservationDao.getDAO().listByLogin(login);
    }
}
