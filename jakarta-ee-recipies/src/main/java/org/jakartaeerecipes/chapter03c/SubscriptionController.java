package org.jakartaeerecipes.chapter03c;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Chapter 5
 *
 * @author juneau
 * <p>
 * Session-scoped bean that is used to hold the list of subscribers.  Uses an
 * ArrayList in the early book chapters, but will evolve to make use of a database
 * later in the book.
 */
@SessionScoped
@Named("ch5SubscriptionController")
public class SubscriptionController implements Serializable {

    private List<Contact> subscriptionList;

    /**
     * Creates a new instance of SubscriptionController
     */
    public SubscriptionController() {
        subscriptionList = new ArrayList();
    }

    /**
     * @return the subscriptionList
     */
    public List<Contact> getSubscriptionList() {
        return subscriptionList;
    }

    /**
     * @param subscriptionList the subscriptionList to set
     */
    public void setSubscriptionList(List<Contact> subscriptionList) {
        this.subscriptionList = subscriptionList;
    }
}
