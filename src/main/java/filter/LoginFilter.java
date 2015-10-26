package filter;

import config.Config;
import utils.AuthenticationUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by ferrilata on 21/10/15.
 */
public class LoginFilter implements Filter {

    private FilterConfig filterConfig = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (filterConfig==null) return;

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession();
        if (AuthenticationUtils.userIsPresent(session)) {
            filterChain.doFilter(request, response);
            return;
        }
        // user not logged in, redirect to the login page
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.sendRedirect(request.getContextPath() + Config.LOGIN_URL);

    }

    @Override
    public void destroy() {
        filterConfig = null;
    }
}
