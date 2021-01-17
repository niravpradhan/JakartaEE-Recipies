package org.jakartaeerecipes.chapter01.recipe01_14;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author juneau
 */
// Uncomment the following line to run example stand-alone
//@WebServlet(name = "MathDispatcher", urlPatterns = {"/MathDispatcher"})

// The following will allow the example to run within the context of the JavaEERecipes example
// enterprise application (javaee8recipes.war distro or Netbeans Project
@WebServlet(name = "MathDispatcher", urlPatterns = {"/chapter01/MathDispatcher"})
public class MathDispatcher extends HttpServlet {

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("In the servlet...");
        // Store the input parameter values into Strings
        String eval = request.getParameter("matheval");
        ServletContext sc = getServletConfig().getServletContext();
        RequestDispatcher rd = null;

        switch (eval) {
            case ("add"):
                rd = sc.getRequestDispatcher("/chapter01/AddServlet");
                rd.forward(request, response);
                break;
            case ("subtract"):
                rd = sc.getRequestDispatcher("/chapter01/SubtractServlet");
                rd.forward(request, response);
                break;
            case ("multiply"):
                rd = sc.getRequestDispatcher("/chapter01/MultiplyServlet");
                rd.forward(request, response);
                break;
            case ("divide"):
                rd = sc.getRequestDispatcher("/chapter01/DivideServlet");
                rd.forward(request, response);
                break;
        }

    }


    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
