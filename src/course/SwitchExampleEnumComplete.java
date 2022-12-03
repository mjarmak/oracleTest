/*
Learn Programming Academy's Java 1Z0-815 Certification Exam Course
Section 4: Using Operators and Decision Constructs
Topic: Decision Constructs
Sub-Topic: Switch Statement
*/

package src.course;

public class SwitchExampleEnumComplete {
    // Set up an enumeration of week days
    enum Day {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
        THURSDAY, FRIDAY, SATURDAY
    }

    public static void main(String[] args) {

        // Example of a Switch statement using an enum. 
        // We'll loop through the weekdays in the enum ...
        for (Day d : Day.values()) {
            switch (d) {
                case MONDAY: // fall through
                case TUESDAY:
                case WEDNESDAY:
                case THURSDAY:
                    System.out.println(d + ": Workday");
                    break;

                case FRIDAY:
                    System.out.println(d + ": TGIF");
                    break;

                case SATURDAY:
                case SUNDAY:
                    System.out.println(d + ": Weekends!");
                    break;

                default:
                    System.out.println("Midweek days are so-so.");
                    break;
            }
        }


        byte[] bytes = {100, 103, 104, 107, 126};
        String caseAssignedValue = "";
        for (var i : bytes) {  // Using LVTI here
            switch (i * 10) {  // Use an Expression
                case 1000:
                case 1030:
                case 1040:
                case 1070:
                    caseAssignedValue = "Less than 1100";
                    break;
                case 1260:
                    caseAssignedValue = "Equal to 1260";
                    break;
            }
            System.out.println("Done processing " + i +
                    ", caseAssignedValue = " + caseAssignedValue);
        }
    }

}