package gov.nysenate.openleg.client.view.calendar;

import gov.nysenate.openleg.model.calendar.CalendarActiveList;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class SimpleActiveListView extends CalendarActiveListIdView{

    protected LocalDate calDate;

    protected LocalDateTime releaseDateTime;

    protected String notes;

    public SimpleActiveListView(CalendarActiveList activeList) {
        super(activeList.getCalendarActiveListId());
        this.calDate = activeList.getCalDate();
        this.releaseDateTime = activeList.getReleaseDateTime();
        this.notes = activeList.getNotes();
    }

    public LocalDate getCalDate() {
        return calDate;
    }

    public LocalDateTime getReleaseDateTime() {
        return releaseDateTime;
    }

    public String getNotes() {
        return notes;
    }
}
