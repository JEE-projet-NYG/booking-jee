package filter;

import config.Config;
import utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.*;
import java.io.IOException;

/**
 * Filter for EntityManager instantiation
 */
public class EntityManagerFilter implements Filter {

    private static EntityManagerFactory entityManagerFactory = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        entityManagerFactory = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        EntityManager em = null;

        try {
            em = entityManagerFactory.createEntityManager();

            EntityManagerUtils.ENTITY_MANAGERS.set(em);
            filterChain.doFilter(servletRequest, servletResponse);
            EntityManagerUtils.ENTITY_MANAGERS.remove();

        } finally {
            try {
                if (em != null) em.close();
            } catch (Throwable t) {
            }
        }
    }

    @Override
    public void destroy() {

    }
}
