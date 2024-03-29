package module6.exceptions_and_io.timeexception;

/**
 * Represents a time in a 24-hour format as a number of hours and minutes. Ranges from [00:00 and 23:59]
 */
public class Time {
    protected final int hours;
    protected final int minutes;
    protected final int seconds; // logic for modifying or displaying seconds is currently deprecated
    
    /**
     * Create a new Time24Hour object, representing a time between (00:00 and 23:59)
     * 
     * @throws TimeFormatException If the time is not within the given range 
     * @hours A number of hours in range [0, 24)
     * @minutes A number of minutes within range [0, 60)
     */
    public Time(int hours, int minutes, int seconds) throws TimeFormatException {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        if (hours < 0 || 24 <= hours 
            || minutes < 0 || 60 <= minutes
            || seconds < 0 || 60 <= seconds
            ) {
            throw new TimeFormatException("Error: " + this.toString() + " is out of bounds [00:00–23:59]");
        }
    }
    /** @return the first component of the time – the number of hours */
    public int getHours() {
        return this.hours;
    }

    /** @return the second component of the time – the number of minutes */
    public int getMinutes() {
        return this.minutes;
    }

    /** @return the third component of the time – the number of seconds */
    public int getSeconds() {
        return this.seconds;
    }

    /**
     * Create a new Time24Hour object by parsing a string
     * 
     * @param time A string formatted like {@code "12:34"}, representing a 24-hour time
     * @throws TimeFormatException if time cannot be parsed, or is out of bounds.
     */
    public static Time parseTime(String time) throws TimeFormatException {
        int hours, minutes;
        String[] components = time.split(":|\\.", 2); // "12:34" => [12, 34];
        if (components.length != 2) {
            throw new TimeFormatException("Error: time must be in the format \"xx:xx\"");
        }
        try {
            hours = Integer.parseInt(components[0]);
            minutes = Integer.parseInt(components[1]);
        } catch (NumberFormatException e) {
            throw new TimeFormatException("Error: \"" + time + "\" is not a valid 24-hour time (ex. \"12:34\")");
        }
        return new Time(hours, minutes, 0);
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d", hours, minutes);
    }
    /**  */
    public String get12HourTime() {
        int hours = this.getHours();
        int minutes = this.getMinutes();
        boolean isPm = (hours >= 12);
        hours %= 12;
        if (hours == 0) {
            hours = 12;
        }
        return String.format("%02d:%02d %s", hours, minutes, (isPm ? "PM" : "AM"));
    }
}