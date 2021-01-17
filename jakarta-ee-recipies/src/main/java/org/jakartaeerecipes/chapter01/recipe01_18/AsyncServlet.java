package org.jakartaeerecipes.chapter01.recipe01_18;

import jakarta.servlet.AsyncContext;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.concurrent.ScheduledThreadPoolExecutor;

//@WebServlet(name = "AsyncServlet", urlPatterns = {"/AsyncServlet"}, asyncSupported = true)
//@WebFilter(urlPatterns="/*", asyncSupported=true)
public class AsyncServlet extends HttpServlet implements Filter {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            System.out.println("Starting doGet");
            AsyncContext ac = request.startAsync();
            ac.addListener(new MyListener());
            System.out.println("Do some stuff in doGet ...");
// Start another service
            ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(10);
            executor.execute(new ServletService(ac));
            System.out.println("Some more stuff in doGet ...");
        } finally {
        }
    }

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        System.out.println("Going through the servlet filter...");
    }
}
