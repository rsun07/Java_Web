package pers.xiaoming.javaweb;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class PermissionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        boolean isLoggedIn = false;
        String path = req.getServletPath();

        // path start with /user requires log in
        if (path.startsWith("/user")) {
            HttpSession session = req.getSession(false);

            if (session != null) {
                if (session.getAttribute("user") != null) {
                    // only session not null and user not null means already logged in
                    isLoggedIn = true;
                    chain.doFilter(request, response);
                }
            }
            if (!isLoggedIn) {
                // session == null or (session != null && user == null) means has not logged in yet
                req.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } else {
            // path not start with /user could be view without log in
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
