package seedu.address.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.event.Event;
import seedu.address.model.event.EventDate;
import seedu.address.model.event.Location;
import seedu.address.model.shared.Name;

public class EventUiTest {
    @BeforeAll
    public static void setUpJavaFX() {
        if (Platform.isFxApplicationThread()) {
            return; // JavaFX is already initialized
        }
        Platform.startup(() -> {});
    }
    @Test
    public void constructor_validEventCard() {
        Event event = new Event(new Name("Party"), new EventDate("2022-12-11"), new Location("RH"));
        EventCard eventCard = new EventCard(event, 1);
        assertEquals(event, eventCard.event);
        assertNotNull(eventCard, "Element should exist");
    }
    @Test
    public void constructor_validEventListPanel() {
        ObservableList<Event> sampleEventList = FXCollections.observableArrayList();
        sampleEventList.addAll(new Event(new Name("Party"), new EventDate("2022-12-11"), new Location("RH")));

        EventListPanel eventListPanel = new EventListPanel(sampleEventList);

        assertEquals(sampleEventList.size(), 1);
        assertNotNull(eventListPanel, "Element should exist");
    }
    @AfterAll
    public static void tearDownJavaFX() {
        if (!Platform.isFxApplicationThread()) {
            return; // JavaFX is not initialized
        }
        Platform.exit(); // Clean up JavaFX resources
    }
}
