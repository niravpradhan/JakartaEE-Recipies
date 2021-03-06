package org.jakartaeerecipes.chapter01.recipe01_08;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SimpleServletCtx1", urlPatterns = {"/SimpleServletCtx1"},
        initParams = {@WebInitParam(name = "name", value = "Duke")})
public class SimpleServletCtx1 extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

        res.setContentType("text/html");

        PrintWriter out = res.getWriter();

        /* Display some response to the user */

        out.println("<html><head>");
        out.println("<title>Simple Servlet Context Example</title>");
        out.println("\t<style>body { font-family: 'Lucida Grande', " +
                "'Lucida Sans Unicode';font-size: 13px; }</style>");
        out.println("</head>");
        out.println("<body>");

        out.println("<p>This is a simple servlet to demonstrate context!  Hello "
                + getServletConfig().getInitParameter("name") + "</p>");

        out.println("</body></html>");

        out.close();
    }
}
