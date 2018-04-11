package pers.xiaoming.javaweb;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class HttpServletParams extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // getParameter("name") is the same as getParameterValues("name")[0]
        String name = req.getParameter("name");
        Integer age = Integer.valueOf(req.getParameter("age"));

        String nameValue = req.getParameterValues("name")[0];

        String[] nameValues = req.getParameterValues("name");

        String inputToOutput = String.format("getParameter(\"name\") is %s \n"
                + "getParameterValues(\"name\")[0] is %s \n"
                + "name values is : %s\n"
                + "age is : %d \n", name, nameValue, Arrays.asList(nameValues).toString(), age);

        System.out.println(inputToOutput);

        PrintWriter out = resp.getWriter();
        out.write(inputToOutput);
    }
}
