package filter;

import config.Config;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ferrilata on 21/10/15.
 */
@WebFilter(urlPatterns = {"/","/"+Config.APP_NAME+"/","/"+Config.APP_NAME+"/reservation"})
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

        Cookie[] cookies = request.getCookies();
        if (cookies!=null) {
            for (Cookie ck : cookies) {
                if (ck.getName().equals(Config.SESSION_ATTRIBUTE)) {
                    filterChain.doFilter(request, response);
                }
            }
        }
        response.setStatus(401);
        request.getRequestDispatcher("/"+Config.APP_NAME+"/login").forward(request,response);

    }

    @Override
    public void destroy() {
        filterConfig = null;
    }
}
