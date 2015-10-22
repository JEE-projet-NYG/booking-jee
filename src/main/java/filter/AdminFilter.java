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

        Cookie[] cookies = request.getCookies();
        if(cookies != null) {
            for (Cookie ck : cookies) {
                if (Config.SESSION_ATTRIBUTE.equals(ck.getName())) {
                    if (Config.SESSION_ADMIN.equals(ck.getValue())) {
                        filterChain.doFilter(request, response);
                        return;
                    } else if(Config.SESSION_USER.equals(ck.getValue())) {
                        // TODO 'forbidden access'
                        //response.sendRedirect(request.getContextPath() + Config.USER_URL);
                        //request.getRequestDispatcher(request.getContextPath() + Config.USER_URL).forward(request,response);
                    }
                } else {
                    // TODO 'user not logged in'
                    // response.sendRedirect(request.getContextPath() + Config.USER_URL);
                    //request.getRequestDispatcher(request.getContextPath() + Config.LOGIN_URL).forward(request, response);
                }
            }
        }

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        request.getRequestDispatcher("/"+Config.APP_NAME+"/login").forward(request, response);

    }

    @Override
    public void destroy() {
        this.filterConfig = null;
    }

}
