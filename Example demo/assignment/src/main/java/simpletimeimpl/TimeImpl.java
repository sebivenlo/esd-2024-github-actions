package simpletimeimpl;

import simpletimeapi.Duration;
import simpletimeapi.Time;
/**
 * This class implements the {@link Time} interface and provides
 * methods for working with time values in hours and minutes.
 */
public class TimeImpl implements Time {
    // The 'hours' and 'minutes' fields are final, meaning once they are set, they cannot be changed.
    // These fields store the normalized hours and minutes of a given time.
    private final int hours;
    private final int minutes;

    /**
     * Constructor to create a TimeImpl object. It takes hours and minutes as input and normalizes them
     * into the valid range [0, 24) for hours and [0, 60) for minutes.
     *
     * @param hours the number of hours
     * @param minutes the number of minutes
     * @throws IllegalArgumentException if the time is outside the valid range of 0 to 23:59
     */
    public TimeImpl(int hours, int minutes) {
        // Convert the given hours and minutes into total minutes for easier manipulation.
        int totalMinutes = hours * 60 + minutes;

        // Total number of minutes in a day (24 hours * 60 minutes = 1440 minutes).
        int minutesInADay = 24 * 60;

        // Check if the total minutes are outside the valid range of a day.
        // If the totalMinutes is less than 0 or greater than or equal to 1440,
        // throw an IllegalArgumentException indicating invalid time.
        if (totalMinutes < 0 || totalMinutes >= minutesInADay) {
            throw new IllegalArgumentException("Time must be within 0 to 23:59");
        }

        // Normalize the time into valid hours and minutes.
        // Divide totalMinutes by 60 to get the normalized hours.
        this.hours = totalMinutes / 60;
        // Use modulus to get the remaining minutes after dividing by 60.
        this.minutes = totalMinutes % 60;
    }

    /**
     * Getter method to retrieve the hours of the time object.
     *
     * @return the number of hours
     */
    @Override
    public int getHours() {
        return hours;
    }

    /**
     * Getter method to retrieve the minutes of the time object.
     *
     * @return the number of minutes
     */
    @Override
    public int getMinutes() {
        return minutes;
    }

    /**
     * Method to add a number of minutes to the current Time object.
     * Returns a new TimeImpl object with the result.
     *
     * @param minutesToAdd the number of minutes to add
     * @return a new TimeImpl object with the updated time
     */
    @Override
    public Time addTime(int minutesToAdd) {
        // Calculate total minutes after adding minutesToAdd to the current time.
        int totalMinutes = this.asMinutes() + minutesToAdd;

        // Total minutes in a day (1440 minutes).
        int minutesInADay = 24 * 60;

        // Normalize the total minutes to ensure it wraps around correctly in a 24-hour format.
        // This ensures that the time is always valid, even if minutesToAdd is positive or negative.
        totalMinutes = ((totalMinutes % minutesInADay) + minutesInADay) % minutesInADay;

        // Create and return a new TimeImpl object with the normalized hours and minutes.
        return new TimeImpl(totalMinutes / 60, totalMinutes % 60);
    }

    /**
     * Overloaded method to add another {@link Time} object to the current time.
     *
     * @param t the other Time object to add
     * @return a new TimeImpl object with the combined time
     */
    @Override
    public Time addTime(Time t) {
        // Use the addTime method by converting the Time object 't' to minutes.
        return addTime(t.asMinutes());
    }

    /**
     * Helper method to return the total number of minutes since midnight.
     *
     * @return the total minutes from 00:00 to the current time
     */
    @Override
    public int asMinutes() {
        return hours * 60 + minutes;  // Convert hours to minutes and add the current minutes.
    }

    /**
     * Calculate the time difference (in minutes) between this time and another Time object.
     * Returns a Duration object representing the time difference.
     *
     * @param other the other Time object
     * @return a {@link Duration} object representing the difference
     */
    @Override
    public Duration until(Time other) {
        // Calculate the difference in minutes between the two times.
        int diff = other.asMinutes() - this.asMinutes();

        // If the difference is negative, assume the other time is on the next day,
        // so add 1440 minutes (24 hours * 60 minutes) to the difference.
        if (diff < 0) {
            diff += 24 * 60;
        }

        // Return a new DurationImpl object with the calculated difference in minutes.
        return new DurationImpl(diff);
    }

    /**
     * Override the equals method to check if two Time objects are equal.
     * Two Time objects are considered equal if they represent the same number of minutes.
     *
     * @param other the object to compare to
     * @return true if the two times are equal, false otherwise
     */
    @Override
    public boolean equals(Object other) {
        // Check if the current object is compared to itself.
        if (this == other) return true;
        // Check if the other object is an instance of the Time interface.
        if (!(other instanceof Time)) return false;
        // Convert the other object to a Time object and compare the total minutes.
        Time that = (Time) other;
        return this.asMinutes() == that.asMinutes();
    }

    /**
     * Override the hashCode method to generate a hash based on the total minutes.
     * This ensures consistency between the equals and hashCode methods.
     *
     * @return the hash code for this time
     */
    @Override
    public int hashCode() {
        return Integer.hashCode(asMinutes());
    }

    /**
     * Override the toString method to return a string representation of the time in "HH:MM" format.
     *
     * @return a string representing the time in "HH:MM" format
     */    @Override
    public String toString() {
        return String.format("%02d:%02d", hours, minutes);  // Format hours and minutes with leading zeros.
    }

    /**
     * Implement the compareTo method from the Comparable interface.
     * This allows Time objects to be compared based on their total minutes.
     *
     * @param other the other Time object to compare to
     * @return a negative integer, zero, or a positive integer if this time is less than, equal to, or greater than the other
     */
    @Override
    public int compareTo(Time other) {
        return Integer.compare(this.asMinutes(), other.asMinutes());  // Compare times based on total minutes.
    }
}
