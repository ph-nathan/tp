package seedu.address.model.member;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalMembers.ALICE;
import static seedu.address.testutil.TypicalMembers.BOB;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.address.model.member.exceptions.DuplicateMemberException;
import seedu.address.model.member.exceptions.MemberNotFoundException;
import seedu.address.testutil.MemberBuilder;

public class UniqueMemberListTest {

    private final UniqueMemberList uniqueMemberList = new UniqueMemberList();

    @Test
    public void contains_nullPerson_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueMemberList.contains(null));
    }

    @Test
    public void contains_personNotInList_returnsFalse() {
        assertFalse(uniqueMemberList.contains(ALICE));
    }

    @Test
    public void contains_personInList_returnsTrue() {
        uniqueMemberList.add(ALICE);
        assertTrue(uniqueMemberList.contains(ALICE));
    }

    @Test
    public void contains_personWithSameIdentityFieldsInList_returnsTrue() {
        uniqueMemberList.add(ALICE);
        Member editedAlice = new MemberBuilder(ALICE).withAddress(VALID_ADDRESS_BOB).withTags(VALID_TAG_HUSBAND)
                .build();
        assertTrue(uniqueMemberList.contains(editedAlice));
    }

    @Test
    public void add_nullPerson_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueMemberList.add(null));
    }

    @Test
    public void add_duplicatePerson_throwsDuplicatePersonException() {
        uniqueMemberList.add(ALICE);
        assertThrows(DuplicateMemberException.class, () -> uniqueMemberList.add(ALICE));
    }

    @Test
    public void setPerson_nullTargetPerson_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueMemberList.setMember(null, ALICE));
    }

    @Test
    public void setPerson_nullEditedPerson_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueMemberList.setMember(ALICE, null));
    }

    @Test
    public void setPerson_targetPersonNotInList_throwsPersonNotFoundException() {
        assertThrows(MemberNotFoundException.class, () -> uniqueMemberList.setMember(ALICE, ALICE));
    }

    @Test
    public void setPerson_editedPersonIsSamePerson_success() {
        uniqueMemberList.add(ALICE);
        uniqueMemberList.setMember(ALICE, ALICE);
        UniqueMemberList expectedUniqueMemberList = new UniqueMemberList();
        expectedUniqueMemberList.add(ALICE);
        assertEquals(expectedUniqueMemberList, uniqueMemberList);
    }

    @Test
    public void setPerson_editedPersonHasSameIdentity_success() {
        uniqueMemberList.add(ALICE);
        Member editedAlice = new MemberBuilder(ALICE).withAddress(VALID_ADDRESS_BOB).withTags(VALID_TAG_HUSBAND)
                .build();
        uniqueMemberList.setMember(ALICE, editedAlice);
        UniqueMemberList expectedUniqueMemberList = new UniqueMemberList();
        expectedUniqueMemberList.add(editedAlice);
        assertEquals(expectedUniqueMemberList, uniqueMemberList);
    }

    @Test
    public void setPerson_editedPersonHasDifferentIdentity_success() {
        uniqueMemberList.add(ALICE);
        uniqueMemberList.setMember(ALICE, BOB);
        UniqueMemberList expectedUniqueMemberList = new UniqueMemberList();
        expectedUniqueMemberList.add(BOB);
        assertEquals(expectedUniqueMemberList, uniqueMemberList);
    }

    @Test
    public void setPerson_editedPersonHasNonUniqueIdentity_throwsDuplicatePersonException() {
        uniqueMemberList.add(ALICE);
        uniqueMemberList.add(BOB);
        assertThrows(DuplicateMemberException.class, () -> uniqueMemberList.setMember(ALICE, BOB));
    }

    @Test
    public void remove_nullPerson_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueMemberList.remove(null));
    }

    @Test
    public void remove_personDoesNotExist_throwsPersonNotFoundException() {
        assertThrows(MemberNotFoundException.class, () -> uniqueMemberList.remove(ALICE));
    }

    @Test
    public void remove_existingPerson_removesPerson() {
        uniqueMemberList.add(ALICE);
        uniqueMemberList.remove(ALICE);
        UniqueMemberList expectedUniqueMemberList = new UniqueMemberList();
        assertEquals(expectedUniqueMemberList, uniqueMemberList);
    }

    @Test
    public void setPersons_nullUniquePersonList_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueMemberList.setMembers((UniqueMemberList) null));
    }

    @Test
    public void setPersons_uniquePersonList_replacesOwnListWithProvidedUniquePersonList() {
        uniqueMemberList.add(ALICE);
        UniqueMemberList expectedUniqueMemberList = new UniqueMemberList();
        expectedUniqueMemberList.add(BOB);
        uniqueMemberList.setMembers(expectedUniqueMemberList);
        assertEquals(expectedUniqueMemberList, uniqueMemberList);
    }

    @Test
    public void setPersons_nullList_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueMemberList.setMembers((List<Member>) null));
    }

    @Test
    public void setPersons_list_replacesOwnListWithProvidedList() {
        uniqueMemberList.add(ALICE);
        List<Member> memberList = Collections.singletonList(BOB);
        uniqueMemberList.setMembers(memberList);
        UniqueMemberList expectedUniqueMemberList = new UniqueMemberList();
        expectedUniqueMemberList.add(BOB);
        assertEquals(expectedUniqueMemberList, uniqueMemberList);
    }

    @Test
    public void setPersons_listWithDuplicatePersons_throwsDuplicatePersonException() {
        List<Member> listWithDuplicateMembers = Arrays.asList(ALICE, ALICE);
        assertThrows(DuplicateMemberException.class, () -> uniqueMemberList.setMembers(listWithDuplicateMembers));
    }

    @Test
    public void asUnmodifiableObservableList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, ()
            -> uniqueMemberList.asUnmodifiableObservableList().remove(0));
    }

    @Test
    public void toStringMethod() {
        assertEquals(uniqueMemberList.asUnmodifiableObservableList().toString(), uniqueMemberList.toString());
    }
}
