package api;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Class representing an attendee
class Attendee {
    private final String name;
    private final String email;

    public Attendee(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public int hashCode() {
        return email.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Attendee other = (Attendee) obj;
        return email.equals(other.email);
    }

    @Override
    public String toString() {
        return name + " (" + email + ")";
    }
}

// Class representing an event
class Event {
    private final String eventName;
    private final Set<Attendee> attendees;

    public Event(String eventName) {
        this.eventName = eventName;
        this.attendees = new HashSet<>();
    }

    public String getEventName() {
        return eventName;
    }

    public Set<Attendee> getAttendees() {
        return attendees;
    }

    public void addAttendee(Attendee attendee) {
        attendees.add(attendee);
    }

    public boolean isAttendeePresent(Attendee attendee) {
        return attendees.contains(attendee);
    }
}

// Main tracker class
class EventAttendanceTracker {
    private final Map<String, Event> events;

    public EventAttendanceTracker() {
        events = new HashMap<>();
    }

    public void addEvent(String eventName) {
        events.putIfAbsent(eventName, new Event(eventName));
    }

    public void registerAttendee(String eventName, Attendee attendee) {
        Event event = events.get(eventName);
        if (event != null) {
            event.addAttendee(attendee);
        } else {
            System.out.println("Event not found.");
        }
    }

    public void listEventAttendees(String eventName) {
        Event event = events.get(eventName);
        if (event != null) {
            System.out.println("Attendees for " + eventName + ":");
            for (Attendee attendee : event.getAttendees()) {
                System.out.println(attendee);
            }
        } else {
            System.out.println("Event not found.");
        }
    }

    public void showAttendanceSummary() {
        for (Map.Entry<String, Event> entry : events.entrySet()) {
            String eventName = entry.getKey();
            Event event = entry.getValue();
            System.out.println("Event: " + eventName + ", Attendees: " + event.getAttendees().size());
        }
    }
}

// Example usage
public class main {
    public static void main(String[] args) {
        EventAttendanceTracker tracker = new EventAttendanceTracker();

        // Add events
        tracker.addEvent("Java Workshop");
        tracker.addEvent("Tech Conference");

        // Create attendees
        Attendee attendee1 = new Attendee("Alice", "alice@example.com");
        Attendee attendee2 = new Attendee("Bob", "bob@example.com");

        // Register attendees
        tracker.registerAttendee("Java Workshop", attendee1);
        tracker.registerAttendee("Java Workshop", attendee2);
        tracker.registerAttendee("Tech Conference", attendee1);

        // List attendees for an event
        tracker.listEventAttendees("Java Workshop");

        // Show attendance summary for all events
        tracker.showAttendanceSummary();
    }
}

