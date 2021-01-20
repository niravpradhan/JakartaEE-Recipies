package org.jakartaeerecipes.common;

import jakarta.faces.event.PhaseEvent;
import jakarta.faces.event.PhaseId;
import jakarta.faces.event.PhaseListener;

import java.util.logging.Logger;

import static java.util.logging.Level.INFO;

public class GlobalPhaseListener implements PhaseListener {

    private static final Logger LOGGER = Logger.getLogger("org.jakartaeerecipes.common.GlobalPhaseListener");

    @Override
    public void afterPhase(PhaseEvent event) {
        LOGGER.log(INFO, "AFTER PHASE: " + event.getPhaseId());
    }

    @Override
    public void beforePhase(PhaseEvent event) {
        LOGGER.log(INFO, "BEFORE PHASE: " + event.getPhaseId());
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }
}
