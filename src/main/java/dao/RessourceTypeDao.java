package dao;

import config.Config;
import model.RessourceType;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by ferrilata on 19/10/15.
 */
public class RessourceTypeDao {

    public static RessourceTypeDao getDAO() { return new RessourceTypeDao(); }

    public RessourceType find(final Long id) { return Config.em.find(RessourceType.class, id); }

    public void create(RessourceType r) { Config.em.persist(r); }

    public void delete(RessourceType r) { Config.em.remove(r); }

    public void delete(final Long id) { Config.em.remove(this.find(id));}

    public void update(RessourceType r) { Config.em.merge(r); }

    public List<RessourceType> listAll() {
        final String displayAllQuery = "SELECT res FROM RessourceType res";
        TypedQuery e = Config.em.createQuery(displayAllQuery, RessourceType.class);
        return e.getResultList();
    }

}
