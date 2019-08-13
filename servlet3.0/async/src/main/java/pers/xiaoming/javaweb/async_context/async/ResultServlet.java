package pers.xiaoming.javaweb.async_context.async;

import pers.xiaoming.javaweb.common.Messages;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

// remember to set async support to true
@WebServlet(value = "/async/context/async/result", asyncSupported = true)
public class ResultServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        while (true) {
            Messages.RESULT_SERVLET_TRY.print();

            HttpSession session = req.getSession();

            int sum = 0;
            try {
                sum = (int) session.getAttribute("sum");
            } catch (Exception e) {
                // do noting
                Messages.RESULT_SERVLET_TRY_FAIL.print();
            }

            if (sum > 0) {
                PrintWriter out = resp.getWriter();
                Messages.RESULT_SERVLET_GET_RESULT.print(out);
                out.println("sum = " + sum);
                break;
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
