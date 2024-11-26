package simpletimeimpl;

import simpletimeapi.Duration;

/**
 * This class implements the {@link Duration} interface and provides
 * methods for working with time durations in hours and minutes.
 */
public class DurationImpl implements Duration {
    // The 'hours' and 'minutes' fields are final, meaning they are immutable once assigned.
    // These fields store the duration in hours and minutes.
    private final int hours;
    private final int minutes;

    /**
     * Constructor that takes the total number of minutes as an input and splits it into hours and minutes.
     * 'totalMinutes' represents the complete duration in minutes, which is then divided to get hours and minutes.
     *
     * @param totalMinutes the total duration in minutes
     */
    public DurationImpl(int totalMinutes) {
        // Normalize total minutes into hours and minutes
        this.hours = totalMinutes / 60;
        this.minutes = totalMinutes % 60;
    }

    /**
     * Constructor that directly takes hours and minutes.
     * This constructor is used when you already have hours and minutes separately.
     * It normalizes excessive minutes (i.e., converts them to hours).
     *
     * @param hours   the number of hours
     * @param minutes the number of minutes
     */
    public DurationImpl(int hours, int minutes) {
        // Normalize excessive minutes into hours
        int totalMinutes = hours * 60 + minutes;
        this.hours = totalMinutes / 60;
        this.minutes = totalMinutes % 60;
    }

    /**
     * Method to return the total duration in minutes.
     * This converts the stored hours and minutes into the equivalent total minutes.
     *
     * @return the total duration in minutes
     */
    @Override
    public int asMinutes() {
        return hours * 60 + minutes;  // Convert hours to minutes and add the stored minutes.
    }

    /**
     * Getter method to retrieve the hours component of the duration.
     *
     * @return the number of hours
     */
    @Override
    public int getHours() {
        return hours;
    }

    /**
     * Getter method to retrieve the minutes component of the duration.
     *
     * @return the number of minutes
     */
    @Override
    public int getMinutes() {
        return minutes;
    }

    /**
     * Method to add another {@link Duration} object to this Duration.
     * Takes another Duration as input, converts both Durations into minutes, adds them together,
     * and returns a new {@link DurationImpl} object representing the result.
     *
     * @param other the other Duration to be added
     * @return a new DurationImpl object representing the combined duration
     */
    @Override
    public Duration plus(Duration other) {
        // Add the total minutes of both durations.
        int totalMinutes = this.asMinutes() + other.asMinutes();
        // Return a new DurationImpl with the total minutes calculated.
        return new DurationImpl(totalMinutes);
    }

    /**
     * Method that returns a string representation of the Duration object.
     * Returns the total duration as a string in the format: "X minutes".
     *
     * @return a string representation of the duration
     */
    @Override
    public String toString() {
        return asMinutes() + " minutes";  // Convert the total minutes to a string.
    }

    /**
     * Override the equals method to check if two Duration objects are equal.
     * Two Duration objects are considered equal if they represent the same number of total minutes.
     *
     * @param other the object to compare to
     * @return true if the two durations are equal, false otherwise
     */
    @Override
    public boolean equals(Object other) {
        // Check if the current object is compared to itself.
        if (this == other) return true;
        // Check if the other object is an instance of the Duration interface.
        if (!(other instanceof Duration)) return false;
        // Convert the other object to a Duration and compare the total minutes.
        Duration that = (Duration) other;
        return this.asMinutes() == that.asMinutes();
    }

    /**
     * Override the hashCode method to ensure consistent behavior with equals.
     * Returns the hash code based on the total minutes of the duration.
     *
     * @return the hash code for this duration
     */
    @Override
    public int hashCode() {
        return Integer.hashCode(asMinutes());  // Generate a hash code based on total minutes.
    }

    /**
     * Implement the compareTo method from the Comparable interface.
     * Compares this Duration object with another Duration based on their total minutes.
     *
     * @param other the other Duration to compare to
     * @return a negative integer, zero, or a positive integer if this duration is less than, equal to, or greater than the other
     */
    @Override
    public int compareTo(Duration other) {
        // Compare the two durations based on their total minutes.
        return Integer.compare(this.asMinutes(), other.asMinutes());
    }
}
