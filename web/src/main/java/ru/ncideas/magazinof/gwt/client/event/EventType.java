package ru.ncideas.magazinof.gwt.client.event;

import java.io.Serializable;

public class EventType implements Serializable {

    private static int count = 0;

    // needed to use FastMap for much better speed
    final String id;

    private int eventCode = -1;

    /**
     * Creates a new event type.
     */
    public EventType() {
        id = String.valueOf(count++);
    }

    /**
     * Creates a new browser based event type.
     *
     * @param eventCode additional information about the event
     */
    public EventType(int eventCode) {
        this();
        this.eventCode = eventCode;
    }

    /**
     * Returns the event code.
     *
     * @return the event code
     * @see Event
     */
    public int getEventCode() {
        return eventCode;
    }

    /**
     * Returns true if the event type represents a browser event type (GWT event).
     *
     * @return true for browser event types
     */
    public boolean isBrowserEvent() {
        return eventCode != -1;
    }

    public String getId() {
        return id;
    }
}
