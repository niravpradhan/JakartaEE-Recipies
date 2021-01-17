package org.jakartaeerecipes.chapter01.recipe01_12;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

// Uncomment the following line to run example stand-alone
//@WebServlet(name="SessionServlet", urlPatterns={"/SessionServlet"}) 

// The following will allow the example to run within the context of the JavaEERecipes example
// enterprise application (javaee8recipes.war distro or Netbeans Project
@WebServlet(name = "SessionServlet", urlPatterns = {"/chapter01/SessionServlet"})
public class SessionServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        // Obtain he Session object

        HttpSession session = req.getSession(true);

        // Set up a session attribute

        String email = (String)
                session.getAttribute("session.email");
        if (email == null) {
            email = req.getParameter("email");
            session.setAttribute("session.email", email);
        }
        String sessionId = session.getId();

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<html>");
        out.println("<head><title>Working with sessions</title></head>");
        out.println("<body>");
        out.println("<h1>Session Test</h1>");
        out.println("Your email address is: " + email + "<br/><br/>");
        out.println("Your session id: " + sessionId);
        out.println("</body></html>");
    }
}