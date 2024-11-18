/*
 * Copyright (c) 2023 Informatics Fontys FHTenL University of Applied Science Venlo
 */
package simpletime;

import simpletimeapi.Duration;
import simpletimeapi.Time;
import simpletimeapi.AbstractSimpleTimeFactory;
import simpletimeimpl.DurationImpl;  // Import the concrete implementation for Duration
import simpletimeimpl.TimeImpl;      // Import the concrete implementation for Time

/**
 * This class implements the AbstractSimpleTimeFactory interface, providing factory methods to
 * create instances of the Time and Duration implementations. These instances will be
 * black-box tested by the teacher's tests.
 *
 * Authors:
 * Richard van den Ham {@code r.vandenham@fontys.nl}
 * Pieter van den Hombergh {@code p.vandenhombergh@fontys.nl}
 */
public class SimpleTimeFactory implements AbstractSimpleTimeFactory {

    /**
     * Public constructor required for service loader to instantiate this factory class.
     * This constructor doesn't require any arguments and is responsible for initializing the factory.
     */
    public SimpleTimeFactory() {
    }

    /**
     * Factory method that creates a Time object.
     * The method takes the number of hours and minutes as parameters and returns a new instance
     * of the TimeImpl class. The TimeImpl class will ensure the hours and minutes are normalized.
     *
     * @param hours - The number of hours (can be negative or greater than 24 but will be normalized).
     * @param minutes - The number of minutes (can be negative or exceed 60 but will be normalized).
     * @return a new TimeImpl instance representing the normalized time.
     */
    @Override
    public Time createTime(int hours, int minutes) {
        // Return a new instance of TimeImpl with the given hours and minutes
        return new TimeImpl(hours, minutes);
    }

    /**
     * Factory method that creates a Duration object.
     * This method takes the number of hours and minutes as parameters and returns an instance
     * of the DurationImpl class. It calculates the total duration using the provided hours and minutes.
     *
     * @param hours - The number of hours in the duration.
     * @param minutes - The number of minutes in the duration.
     * @return a new DurationImpl instance representing the total duration.
     */
    @Override
    public Duration createDuration(int hours, int minutes) {
        // Return a new instance of DurationImpl with the given hours and minutes
        return new DurationImpl(hours, minutes);
    }

    /**
     * Factory method that creates a Duration object based on the total number of minutes.
     * The method takes the total length in minutes and converts it into hours and minutes
     * to create an instance of the DurationImpl class.
     *
     * @param lengthInMinutes - The total duration in minutes.
     * @return a new DurationImpl instance representing the duration with hours and minutes calculated.
     */
    @Override
    public Duration createDuration(int lengthInMinutes) {
        // Return a new instance of DurationImpl with the total minutes provided
        return new DurationImpl(lengthInMinutes);
    }
}
