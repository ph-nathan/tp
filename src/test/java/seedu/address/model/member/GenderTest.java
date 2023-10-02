package seedu.address.model.member;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class GenderTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Gender(null));
    }

    @Test
    public void constructor_invalidGender_throwsIllegalArgumentException() {
        String invalidGender = "";
        assertThrows(IllegalArgumentException.class, () -> new Gender(invalidGender));
    }

    @Test
    public void isValidGender() {
        // null Gender
        assertThrows(NullPointerException.class, () -> Gender.isValidGender(null));

        // invalid Genders
        assertFalse(Gender.isValidGender("")); // empty string
        assertFalse(Gender.isValidGender(" ")); // spaces only
        assertFalse(Gender.isValidGender("Apache Helicopter")); // not part of three choices

        // valid Genders
        assertTrue(Gender.isValidGender("Male"));
        assertTrue(Gender.isValidGender("Female"));
        assertTrue(Gender.isValidGender("Others"));
    }

    @Test
    public void equals() {
        Gender Gender = new Gender("Male");

        // same values -> returns true
        assertTrue(Gender.equals(new Gender("Male")));

        // same object -> returns true
        assertTrue(Gender.equals(Gender));

        // null -> returns false
        assertFalse(Gender.equals(null));

        // different types -> returns false
        assertFalse(Gender.equals(5.0f));

        // different values -> returns false
        assertFalse(Gender.equals(new Gender("Others")));
    }
}
