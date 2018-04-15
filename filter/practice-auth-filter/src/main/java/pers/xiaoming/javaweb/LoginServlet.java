package pers.xiaoming.javaweb;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoginServlet extends HttpServlet {
    private static final Map<String, String> userDao;

    static {
        userDao = new HashMap<>();
        userDao.put("root", "root");
        userDao.put("myuser", "123");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        boolean isLoggedIn = false;
        String username = req.getParameter("uname");

        if (username != null && userDao.containsKey(username)) {
            String password = req.getParameter("pword");
            if (userDao.get(username).equals(password)) {
                isLoggedIn = true;

                HttpSession session = req.getSession();
                session.setAttribute("user", username);
                resp.sendRedirect("/user/welcome.jsp");
            }
        }

        if (!isLoggedIn) {
            resp.getWriter().write("Log in fail, please try again");
            resp.sendRedirect("/login.jsp");
        }
    }
}
