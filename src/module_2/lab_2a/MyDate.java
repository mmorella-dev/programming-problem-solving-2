package module_2.lab_2a;

/**
 * MyDate
 */
public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    /**
     * @return the date formatted like "YYYY-MM-DD"
     */
    @Override
    public String toString() {
        return String.format("%4d-%2d-%2d", year, month, day);
    }
}