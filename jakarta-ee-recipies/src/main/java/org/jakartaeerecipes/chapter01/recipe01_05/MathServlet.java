package org.jakartaeerecipes.chapter01.recipe01_05;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Recipe 1-6: Handling Requests and Responses
 */
// Uncomment the following line to run example stand-alone
//@WebServlet(name="MathServlet", urlPatterns={"/MathServlet"}) 

// The following will allow the example to run within the context of the JavaEERecipes example
// enterprise application (javaee8recipes.war distro or Netbeans Project)
@WebServlet(name = "MathServlet", urlPatterns = {"/chapter01/MathServlet"})
public class MathServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

        res.setContentType("text/html");

        // Store the input parameter values into Strings
        String numA = req.getParameter("numa");
        String numB = req.getParameter("numb");

        PrintWriter out = res.getWriter();
        out.println("<html><head>");
        out.println("<title>Test Math Servlet- a gogo</title>");
        out.println("\t<style>body { font-family: 'Lucida Grande', "
                + "'Lucida Sans Unicode';font-size: 13px; }</style>");
        out.println("</head>");
        out.println("<body>");

        try {
            int solution = Integer.valueOf(numA) + Integer.valueOf(numB);

            /*
             * Display some response to the user
             */
            out.println("<p>Solution: "
                    + numA + " + " + numB + " = " + solution + "</p>");

        } catch (NumberFormatException ex) {
            // Display error if an exception is raised
            out.println("<p>Please use numbers only...try again.</p>");
        }
        out.println("<br/><br/>");
        out.println("<a href='recipe01_05.html'>Add Two More Numbers</a>");
        out.println("</body></html>");

        out.close();
    }
}
