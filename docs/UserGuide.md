---
layout: page
title: User Guide
---
## CACommander Ultra Promax Xtra 9000PLUS - User Guide
CCACommander Ultra Promax Xtra 9000PLUS is the one stop app for CCA Heads to manage CCA members and events, optimised for CCA Heads who prefer to use command line interface.

* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest `ccacommander.jar` from [here](https://github.com/AY2324S1-CS2103T-F11-1/tp/releases).

1. Copy the file to the folder you want to use as the _home folder_ for your CCACommander application.

1. Open a command terminal, `cd` into the folder you put the jar file in, and use the `java -jar ccacommander.jar` command to run the application.<br>
   A GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

1. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * `list` : Lists all members and events.

   * `create /member n/CHU WEI RONG g/Male p/98765432 e/chuweirongrocks@gmail.com a/19 Kent Ridge Crescent, Singapore 119278` : Creates a member named `CHU WEI RONG` to CCACommander.

   * `delete /member 3` : Deletes the 3rd member shown in the current list.

1. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/John Doe`.

* Items in square brackets are optional.<br>
  e.g `n/NAME [t/TAG]` can be used as `n/John Doe t/friend` or as `n/John Doe`.

* Items with `…`​ after them can be used multiple times including zero times.<br>
  e.g. `[t/TAG]…​` can be used as ` ` (i.e. 0 times), `t/friend`, `t/friend t/family` etc.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

* Extraneous parameters for commands that do not take in parameters (such as `help`, `list`, `exit` and `clear`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

* If you are using a PDF version of this document, be careful when copying and pasting commands that span multiple lines as space characters surrounding line-breaks may be omitted when copied over to the application.
</div>

### Create a Member: `create /member`
Creates a new member with accompanying personal details (name, phone number, email address, home address).

Format: `create /member n/MEMBER_NAME g/GENDER [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS]`

* Acceptable values for `GENDER`: `Male`, `Female`, `Others`
* Acceptable values for `EMAIL`: A string with an email extension (e.g. `@gmail.com`)

### Delete a Member : `delete /member`

Deletes the member at the specified index.

Format: `delete /member MEMBER_INDEX`

* Deletes the member at the specified `MEMBER_INDEX`.
* The index refers to the index number shown in the displayed member list.
* The index **must be a positive integer** that is within the range of the length of the member list.

Examples:
* `delete /member 1 ` deletes the 1st member in the member list.
* `delete /member 10 ` deletes the 10th member in the member list.

### List all Members and all Events : `list`

List all members and all events in the CCA in 2 separate columns.

Format: `list`

### View Members of Event : `view /event`

Lists all the members of a specified event index.

Format: `view /event EVENT_INDEX`
* Views the members of the event at the specified `EVENT_INDEX`.
* The index refers to the index number shown in the displayed event list.
* The index **must be a positive integer** that is within the range of the length of the event list.

Examples:
* `view /event 1` displays members of the 1st event in the event list.
* `view /event 10` displays members of the 10th event in the event list.

### View Events of Member : `view /member`

Lists all the events of a specified member index.

Format: `view /member MEMBER_INDEX`
* Views the events of the member at the specified `MEMBER_INDEX`.
* The index refers to the index number shown in the displayed member list.
* The index **must be a positive integer** that is within the range of the length of the member list.

Examples:
* `view /member 1` displays members of the 1st member in the member list.
* `view /member 10` displays members of the 10th member in the member list.

### Create an Event : `create /event`

Creates a new event and adds it to the database.

Format: `create /event n/EVENT_NAME [l/LOCATION] [d/DATE]`

Examples:
* `create /event n/Party l/Raffles Hall d/16-09-2023`
* `create /event n/Combined Hall Ensemble Concert d/16-02/2024` 

### Delete an Event: `delete /event`

Deletes the event at the specified index.

Format: `delete /event EVENT_INDEX`

* Deletes the event at the specified `EVENT_INDEX`.
* The index refers to the index number shown in the displayed event list.
* The index **must be a positive integer** that is within the range of the length of the event list.

Examples:
* `delete /event 1 ` deletes the 1st event in the event list.
* `delete /event 10 ` deletes the 10th event in the event list.

### Add Member to an Event: `add /member /event`

Adds a member to an event. 

Format: `add /member MEMBER_INDEX /event EVENT_INDEX`

* Adds the member at the specified `MEMBER_INDEX` to the event at the specified `EVENT_INDEX`.
* The `MEMBER_INDEX`/`EVENT_INDEX` refers to the index number shown in the displayed member/event list.
* The `MEMBER_INDEX`/`EVENT_INDEX` **must be a positive integer** that is within the range of the length of the member/event list.

Examples:
* `add /member 1 /event 5` adds the 1st member in the member list to the 5th event in the event list.
* `add /member 5 /event 1` adds the 5th member in the member list to the 1st event in the event list.

### Delete Member from an Event: `delete /member /event`

Deletes a member from an event.

Format: ` delete /member MEMBER_INDEX /event EVENT_INDEX`

* Delete the member at the specified `MEMBER_INDEX` from the event at the specified `EVENT_INDEX`.
* The member at `MEMBER_INDEX` must be a part of the event at `EVENT_INDEX`
* The `MEMBER_INDEX`/`EVENT_INDEX` refers to the index number shown in the displayed member/event list.
* The `MEMBER_INDEX`/`EVENT_INDEX` **must be a positive integer** that is within the range of the length of the member/event list.


Examples:
* `delete /member 1 /event 5` deletes the 1st member in the member list from the 5th event in the event list.
* `delete /member 5 /event 1` deletes the 5th member in the member list from the 1st event in the event list.

## FEATURES FROM AB3 (START)
### Viewing help : `help`

Shows a message explaining how to access the help page.

![help message](images/helpMessage.png)

Format: `help`


### Adding a person: `add`

Adds a person to the address book.

Format: `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…​`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
A person can have any number of tags (including 0)
</div>

Examples:
* `add n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01`
* `add n/Betsy Crowe t/friend e/betsycrowe@example.com a/Newgate Prison p/1234567 t/criminal`

### Listing all persons : `list`

Shows a list of all persons in the address book.

Format: `list`

### Editing a person : `edit`

Edits an existing person in the address book.

Format: `edit INDEX [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [t/TAG]…​`

* Edits the person at the specified `INDEX`. The index refers to the index number shown in the displayed person list. The index **must be a positive integer** 1, 2, 3, …​
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* When editing tags, the existing tags of the person will be removed i.e adding of tags is not cumulative.
* You can remove all the person’s tags by typing `t/` without
    specifying any tags after it.

Examples:
*  `edit 1 p/91234567 e/johndoe@example.com` Edits the phone number and email address of the 1st person to be `91234567` and `johndoe@example.com` respectively.
*  `edit 2 n/Betsy Crower t/` Edits the name of the 2nd person to be `Betsy Crower` and clears all existing tags.

### Locating persons by name: `find`

Finds persons whose names contain any of the given keywords.

Format: `find KEYWORD [MORE_KEYWORDS]`

* The search is case-insensitive. e.g `hans` will match `Hans`
* The order of the keywords does not matter. e.g. `Hans Bo` will match `Bo Hans`
* Only the name is searched.
* Only full words will be matched e.g. `Han` will not match `Hans`
* Persons matching at least one keyword will be returned (i.e. `OR` search).
  e.g. `Hans Bo` will return `Hans Gruber`, `Bo Yang`

Examples:
* `find John` returns `john` and `John Doe`
* `find alex david` returns `Alex Yeoh`, `David Li`<br>
  ![result for 'find alex david'](images/findAlexDavidResult.png)

### Deleting a person : `delete`

Deletes the specified person from the address book.

Format: `delete INDEX`

* Deletes the person at the specified `INDEX`.
* The index refers to the index number shown in the displayed person list.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `list` followed by `delete 2` deletes the 2nd person in the address book.
* `find Betsy` followed by `delete 1` deletes the 1st person in the results of the `find` command.

### Clearing all entries : `clear`

Clears all entries from the address book.

Format: `clear`

### Exiting the program : `exit`

Exits the program.

Format: `exit`

### Saving the data

AddressBook data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Editing the data file

AddressBook data are saved automatically as a JSON file `[JAR file location]/data/addressbook.json`. Advanced users are welcome to update data directly by editing that data file.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
If your changes to the data file makes its format invalid, AddressBook will discard all data and start with an empty data file at the next run. Hence, it is recommended to take a backup of the file before editing it.
</div>

### Archiving data files `[coming in v2.0]`

_Details coming soon ..._
## FEATURES FROM AB3 (END)


--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous AddressBook home folder.

--------------------------------------------------------------------------------------------------------------------

## Known issues

1. **When using multiple screens**, if you move the application to a secondary screen, and later switch to using only the primary screen, the GUI will open off-screen. The remedy is to delete the `preferences.json` file created by the application before running the application again.

--------------------------------------------------------------------------------------------------------------------

## Command summary

Action | Format, Examples
--------|------------------
**Create a member** | `create /member n/MEMBER_NAME g/GENDER [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS]` <br> e.g. `create /member n/CHU WEI RONG g/Male p/98765432 e/chuweirongrocks@gmail.com a/19 Kent Ridge Crescent, Singapore 119278`
**Delete a member** | `delete /member MEMBER_INDEX` <br> e.g.`delete /member 1`
**List all members and all events** | `list`
**View members of event** | `view /event EVENT_INDEX` <br> e.g.`view /event 1`
**View events of member** | `view /member MEMBER_INDEX` <br> e.g.`view /member 1`
**Create an event** | `create /event n/EVENT_NAME [l/LOCATION] [d/DATE]` <br> e.g.`create /event n/Party l/Raffles Hall d/16-09-2023`
**Delete an event** | `delete /event EVENT_INDEX` <br> e.g.`delete /event 1`
**Add member to an event** | `add /member MEMBER_INDEX /event EVENT_INDEX` <br> e.g.`add /member 1 /event 5`
**Delete member from an event** | `delete /member MEMBER_INDEX /event EVENT_INDEX` <br> e.g.`delete /member 1 /event 5`
**Edit** | coming soon...
**Find** | coming soon...
**Help** | coming soon...
