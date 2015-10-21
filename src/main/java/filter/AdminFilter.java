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
@WebFilter(urlPatterns = {"/"+Config.APP_NAME+"/users","/"+Config.APP_NAME+"/resources","/"+Config.APP_NAME+"/resourceTypes"})
public class AdminFilter implements Filter {

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
        for (Cookie ck : cookies) {
            if (ck.getName().equals(Config.SESSION_ATTRIBUTE)) {
                if (ck.getValue().equals(Config.SESSION_ADMIN)) {
                    filterChain.doFilter(request, response);
                } else {
                    request.getRequestDispatcher(request.getContextPath() + Config.USER_URL).forward(request,response);
                }
            } else {
                request.getRequestDispatcher(request.getContextPath() + Config.USER_URL).forward(request, response);
            }
        }
    }

    @Override
    public void destroy() {
        this.filterConfig = null;
    }

}
