package org.jakartaeerecipes.chapter01.recipe01_10;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;

/**
 * Recipe 1-10:  Attribute Listener
 */
@WebListener
public final class AttributeListener implements ServletContextListener,
        HttpSessionAttributeListener {

    private ServletContext context = null;

    public void attributeAdded(HttpSessionBindingEvent se) {
        HttpSession session = se.getSession();
        String id = session.getId();
        String name = se.getName();
        String value = se.getValue().toString();
        String message = new StringBuffer("New attribute has been added to session: \n").append("Attribute Name: ").append(name).append("\n").append("Attribute Value:").append(value).toString();
        log(message);
    }

    public void attributeRemoved(HttpSessionBindingEvent se) {
        HttpSession session = se.getSession();
        String id = session.getId();
        String name = se.getName();
        if (name == null) {
            name = "Unknown";
        }
        String value = se.getValue().toString();
        String message = new StringBuffer("Attribute has been removed: \n").append("Attribute Name: ").append(name).append("\n").append("Attribute Value: ").append(value).toString();
        log(message);
    }

    public void attributeReplaced(HttpSessionBindingEvent se) {
        String name = se.getName();
        if (name == null) {
            name = "Unknown";
        }
        String value = (String) se.getValue();
        String message = new StringBuffer("Attribute has been replaced: \n ").append(name).toString();
        log(message);
    }

    private void log(String message) {
        if (context != null) {
            context.log("SessionListener: " + message);
        } else {
            System.out.println("SessionListener: " + message);
        }
    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
        this.context = event.getServletContext();
        log("contextInitialized()");
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
// Do something
    }
}
                   