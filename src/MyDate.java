
// Create a reusable object type (class) called MyDate
//         Add attributes to the MyDate class
// Add multiple constructors to the MyDate class
// Add methods to the MyDate class
// Test your definition of the MyDate class with a previously coded test class
// Explore an initialization block in MyDate

public class MyDate {

    // Add attributes
    int day;
    int year;
    int month;

    // Initialization Block
    {
        month = 1;
        day = 1;
        year = 2000;
    }

    // No-arg Constructor
    public MyDate() {}

    // Constructor
    public MyDate(int m, int d, int y) {
        month = m;
        day = d;
        year = y;
    }

    public String toString() {
        return String.format("%d/%d/%d", month, day, year);
    }

    public void setDate(int m, int d, int y) {
        month = m;
        day = d;
        year = y;
    }
}
