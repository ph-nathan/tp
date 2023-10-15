package seedu.address.testutil;

import static seedu.address.testutil.TypicalEvents.getTypicalEvents;
import static seedu.address.testutil.TypicalMembers.getTypicalMembers;

import seedu.address.model.AddressBook;
import seedu.address.model.event.Event;
import seedu.address.model.member.Member;

/**
 * A utility class which returns an AddressBook with all typical members and events.
 */
public class TypicalAddressBook {
    /**
     * Returns an {@code AddressBook} with all the typical members and events.
     */
    public static AddressBook getTypicalAddressBook() {
        AddressBook ab = new AddressBook();
        for (Member member : getTypicalMembers()) {
            ab.createMember(member);
        }

        for (Event event: getTypicalEvents()) {
            ab.addEvent(event);
        }

        return ab;
    }
}
