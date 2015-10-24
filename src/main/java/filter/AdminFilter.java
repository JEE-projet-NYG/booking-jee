package filter;

import config.Config;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by ferrilata on 21/10/15.
 */
public class AdminFilter implements Filter {

    private FilterConfig filterConfig = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("AdminFilter");

        if (filterConfig==null) return;

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession();
        try {
            Object status = session.getAttribute(Config.SESSION_ATTRIBUTE);
            if (status!=null) {
                if (status.equals(Config.SESSION_ADMIN)) {
                    filterChain.doFilter(request, response);
                    return;
                } else if (status.equals(Config.SESSION_USER)) {
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    response.sendRedirect(request.getContextPath() + Config.USER_URL);
                    return;
                }
            }
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.sendRedirect(Config.LOGIN_URL);
            return;
        } catch (IllegalStateException e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.sendRedirect(Config.LOGIN_URL);
            return;
        }
    }

    @Override
    public void destroy() {
        this.filterConfig = null;
    }

}
