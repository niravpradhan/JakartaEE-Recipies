package org.jakartaeerecipes.chapter03c;

import jakarta.faces.context.FacesContext;
import jakarta.faces.event.PhaseEvent;
import jakarta.faces.event.PhaseId;

/**
 * Recipe 05-15
 *
 * @author juneau
 */
public class BookstorePhaseListener implements jakarta.faces.event.PhaseListener {

    @Override
    public void beforePhase(PhaseEvent event) {
        FacesContext.getCurrentInstance().getExternalContext().log("Before the Phase - "
                + event.getPhaseId());

    }

    @Override
    public void afterPhase(PhaseEvent event) {
        FacesContext.getCurrentInstance().getExternalContext().log("After the Phase - "
                + event.getPhaseId());
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }
}
