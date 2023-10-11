package seedu.address.model.event;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

import seedu.address.commons.util.ToStringBuilder;

/**
 * Represents a Person in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Event {

    // Identity fields
    private final EventName eventName;

    // Data fields
    private final Location location;
    private final EventDate eventDate;

    /**
     * Every field must be present and not null.
     */
    public Event(EventName eventName, EventDate eventDate, Location location){
        requireAllNonNull(eventName, eventDate, location);
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.location = location;
    }

    public EventName getName() {
        return eventName;
    }

    public Location getLocation() {
        return location;
    }
    public EventDate getDate() {
        return eventDate;
    }

    /**
     * Returns true if both persons have the same name.
     * This defines a weaker notion of equality between two persons.
     */
    public boolean isSameEvent(Event otherEvent) {
        if (otherEvent == this) {
            return true;
        }

        return otherEvent != null
                && otherEvent.getName().equals(getName());
    }

    /**
     * Returns true if both events have the same identity and data fields.
     * This defines a stronger notion of equality between two events.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Event)) {
            return false;
        }

        Event otherEvent = (Event) other;
        return eventName.equals(otherEvent.eventName)
                && location.equals(otherEvent.location)
                && eventDate.equals(otherEvent.eventDate);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(eventName, location, eventDate);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("name", eventName)
                .add("date", eventDate)
                .add("location", location)
                .toString();
    }

}
