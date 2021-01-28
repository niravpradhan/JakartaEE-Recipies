package org.jakartaeerecipes.chapter03c.recipe03c_08;

import jakarta.faces.application.Application;
import jakarta.faces.event.*;

/**
 * Recipe 5-8: System Event Listener
 *
 * @author juneau
 */
public class BookstoreAppListener implements SystemEventListener {

    @Override
    public void processEvent(SystemEvent event) throws AbortProcessingException {
        if (event instanceof PostConstructApplicationEvent) {
            System.out.println("The application has been constructed...");
        }

        if (event instanceof PreDestroyApplicationEvent) {
            System.out.println("The application is being destroyed...");
        }
    }

    @Override
    public boolean isListenerForSource(Object source) {
        return (source instanceof Application);
    }

}
