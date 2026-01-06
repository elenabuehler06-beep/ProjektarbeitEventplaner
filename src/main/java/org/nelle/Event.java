package org.nelle;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Event {
    private final String eventName;
    private final String eventDescription;
    private final String eventLocation;
    private final int eventCost;
    private final LocalDate eventDatum;
    private boolean eventTimely;

    public Event(String name, String description, String location, int cost, LocalDate datum) {
        this.eventName = name;
        this.eventDescription = description;
        this.eventLocation = location;
        this.eventCost = cost;
        this.eventDatum = datum;
        this.eventTimely = checkTimely(datum);
    }

    //source: https://stackoverflow.com/questions/48233470/how-to-compare-when-two-dates-are-within-30-days
    public boolean checkTimely(LocalDate datum) {
        LocalDateTime currentDate = LocalDate.now().atStartOfDay();
        LocalDateTime checkDate = datum.atStartOfDay();
        long distanceInDays = Duration.between(currentDate, checkDate).toDays();

        if ((distanceInDays <= 30) && (distanceInDays > 0)) {
            return true;
        } else {
            return false;
        }
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventLocation () { return eventLocation; }

    public String getEventDescription() {
        return eventDescription;
    }

    public int getEventCost() {
        return eventCost;
    }

    public LocalDate getEventDatum() {
        return eventDatum;
    }

    public boolean getEventTimely() {
        return eventTimely;
    }

}
