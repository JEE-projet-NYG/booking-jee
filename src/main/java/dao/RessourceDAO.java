package dao;

import config.Config;
import model.Ressource;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by ferrilata on 19/10/15.
 */
public class RessourceDAO {

    public static RessourceDAO getDAO() { return new RessourceDAO(); }

    public Ressource find(final Long id) { Config.em.find(Ressource.class, id); }

    public void create(Ressource r) { Config.em.persist(r); }

    public void delete(Ressource r) { Config.em.remove(r); }

    public void delete(final Long id) { Config.em.remove(this.find(id));}

    public void update(Ressource r) { Config.em.merge(r); }

    public List<Ressource> listAll() {
        final String displayAllQuery = "SELECT res FROM Ressource res";
        TypedQuery e = Config.em.createQuery(displayAllQuery, Ressource.class);
        return e.getResultList();
    }

    public List<Ressource> list(final String name) {
        final String displayByNameQuery = "SELECT res" +
                                          "FROM Ressource res" +
                                          "WHERE res.name like '%'"+name+"'%'";
    }


}
