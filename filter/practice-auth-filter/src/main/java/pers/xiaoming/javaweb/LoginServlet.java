package pers.xiaoming.javaweb;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        String username = req.getParameter("user");

        if (username != null && userDao.containsKey(username)) {
            String password = req.getParameter("password");
            if (userDao.get(username).equals(password)) {
                resp.sendRedirect(req.getContextPath() +"/user/user_welcome.jsp");
            }
        }
        resp.getWriter().write("Log in fail, please try again");
        resp.sendRedirect(req.getContextPath() + "/login.jsp");
    }
}
