package org.jakartaeerecipes.chapter01.recipe01_11;

import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Recipe 1-11: Applying a Session Listener
 *
 * @author juneau
 */
@WebListener
public class SessionListener implements HttpSessionListener {

    private AtomicInteger numberOfSessions;

    public SessionListener() {
        numberOfSessions = new AtomicInteger();
    }

    public AtomicInteger getNumberOfSessions() {
        return numberOfSessions;
    }

    @Override
    public void sessionCreated(HttpSessionEvent arg) {
        HttpSession session = arg.getSession();
        ServletContext servletContext = session.getServletContext();
        session.setMaxInactiveInterval(180);
        session.setAttribute("testAttr", "testVal");
        servletContext.log("Session created, current count: " + numberOfSessions.incrementAndGet());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent arg) {
        HttpSession session = arg.getSession();
        ServletContext servletContext = session.getServletContext();
        servletContext.log("Session destroyed, current count: " + numberOfSessions.decrementAndGet());
        servletContext.log("The attribute value: " + session.getAttribute(("testAttr")));
    }
}
