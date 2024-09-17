package simpletimeimpl;

import org.junit.jupiter.api.Test;
import simpletimeapi.Duration;
import simpletimeapi.Time;

import static org.junit.jupiter.api.Assertions.*;

class TimeImplTest {

    @Test
    void testConstructorWithValidTime() {
        // Arrange
        int hours = 10;
        int minutes = 45;

        // Act
        Time time = new TimeImpl(hours, minutes);

        // Assert
        assertEquals(10, time.getHours(), "Expected hours to be 10");
        assertEquals(45, time.getMinutes(), "Expected minutes to be 45");
    }

    @Test
    void testConstructorWithValidBoundaryTime() {
        // Arrange
        int hours = 23;
        int minutes = 59;

        // Act
        Time time = new TimeImpl(hours, minutes);

        // Assert
        assertEquals(23, time.getHours(), "Expected hours to be 23");
        assertEquals(59, time.getMinutes(), "Expected minutes to be 59");
    }

    @Test
    void testConstructorWithTooManyMinutesThrowsException() {
        // Arrange
        int hours = 24; // Exceeds valid 23:59

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> new TimeImpl(hours, 0),
                "Expected exception when hours exceed 23");
    }

    @Test
    void testConstructorWithNegativeMinutesNormalized() {
        // Arrange
        int hours = 10;
        int minutes = -15;  // -15 minutes from 10:00 should result in 9:45

        // Act
        Time time = new TimeImpl(hours, minutes);

        // Assert
        assertEquals(9, time.getHours(), "Expected hours to be 9 after normalizing negative minutes");
        assertEquals(45, time.getMinutes(), "Expected minutes to be 45 after normalizing negative minutes");
    }


    @Test
    void testConstructorWithTotalMinutesOutOfBoundsThrowsException() {
        // Arrange
        int hours = 25;  // More than 24 hours
        int minutes = 120; // More than 60 minutes

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> new TimeImpl(hours, minutes),
                "Expected exception when total time exceeds 24 hours");
    }

    @Test
    void testAddTimeWithMinutesWrapAround() {
        // Arrange
        Time time = new TimeImpl(23, 30); // 11:30 PM

        // Act
        Time newTime = time.addTime(120); // Add 2 hours (should wrap to 01:30 AM)

        // Assert
        assertEquals(1, newTime.getHours(), "Expected hours to wrap around to 1 AM");
        assertEquals(30, newTime.getMinutes(), "Expected minutes to remain 30");
    }

    @Test
    void testAddTimeWithNegativeMinutes() {
        // Arrange
        Time time = new TimeImpl(2, 30); // 2:30 AM

        // Act
        Time newTime = time.addTime(-180); // Subtract 3 hours (should wrap to 11:30 PM)

        // Assert
        assertEquals(23, newTime.getHours(), "Expected hours to wrap around to 11 PM");
        assertEquals(30, newTime.getMinutes(), "Expected minutes to remain 30");
    }

    @Test
    void testAddTimeWithAnotherTimeObject() {
        // Arrange
        Time time1 = new TimeImpl(10, 30); // 10:30 AM
        Time time2 = new TimeImpl(3, 45); // 3:45 AM

        // Act
        Time result = time1.addTime(time2); // Adding 3:45 to 10:30

        // Assert
        assertEquals(14, result.getHours(), "Expected hours to be 14 (2:15 PM)");
        assertEquals(15, result.getMinutes(), "Expected minutes to be 15");
    }

    @Test
    void testAsMinutes() {
        // Arrange
        Time time = new TimeImpl(2, 30); // 2:30 AM

        // Act
        int minutes = time.asMinutes();

        // Assert
        assertEquals(150, minutes, "Expected total minutes to be 150 (2 hours 30 minutes)");
    }

    @Test
    void testUntilMethodWithTimeOnNextDay() {
        // Arrange
        Time time1 = new TimeImpl(23, 45); // 11:45 PM
        Time time2 = new TimeImpl(0, 15);  // 12:15 AM the next day

        // Act
        Duration duration = time1.until(time2);

        // Assert
        assertEquals(30, duration.asMinutes(), "Expected duration to be 30 minutes");
    }

    @Test
    void testUntilMethodWithinSameDay() {
        // Arrange
        Time time1 = new TimeImpl(10, 30); // 10:30 AM
        Time time2 = new TimeImpl(12, 0);  // 12:00 PM

        // Act
        Duration duration = time1.until(time2);

        // Assert
        assertEquals(90, duration.asMinutes(), "Expected duration to be 90 minutes");
    }

    @Test
    void testEqualsMethodWithSameTime() {
        // Arrange
        Time time1 = new TimeImpl(10, 30); // 10:30 AM
        Time time2 = new TimeImpl(10, 30); // 10:30 AM

        // Act & Assert
        assertTrue(time1.equals(time2), "Expected both Time objects to be equal");
    }

    @Test
    void testEqualsMethodWithDifferentTime() {
        // Arrange
        Time time1 = new TimeImpl(10, 30); // 10:30 AM
        Time time2 = new TimeImpl(11, 30); // 11:30 AM

        // Act & Assert
        assertFalse(time1.equals(time2), "Expected Time objects with different times to not be equal");
    }

    @Test
    void testEqualsMethodWithNull() {
        // Arrange
        Time time = new TimeImpl(10, 30); // 10:30 AM

        // Act & Assert
        assertFalse(time.equals(null), "Expected Time object to not be equal to null");
    }

    @Test
    void testHashCodeConsistency() {
        // Arrange
        Time time = new TimeImpl(10, 30); // 10:30 AM

        // Act
        int hashCode1 = time.hashCode();
        int hashCode2 = time.hashCode();

        // Assert
        assertEquals(hashCode1, hashCode2, "Expected hashCode to remain consistent across multiple calls");
    }

    @Test
    void testCompareToMethodWithSameTime() {
        // Arrange
        Time time1 = new TimeImpl(10, 30); // 10:30 AM
        Time time2 = new TimeImpl(10, 30); // 10:30 AM

        // Act & Assert
        assertEquals(0, time1.compareTo(time2), "Expected compareTo to return 0 for same times");
    }

    @Test
    void testCompareToMethodWithEarlierTime() {
        // Arrange
        Time time1 = new TimeImpl(10, 30); // 10:30 AM
        Time time2 = new TimeImpl(9, 30);  // 9:30 AM

        // Act & Assert
        assertTrue(time1.compareTo(time2) > 0, "Expected compareTo to return a positive value when time1 is later");
    }

    @Test
    void testCompareToMethodWithLaterTime() {
        // Arrange
        Time time1 = new TimeImpl(10, 30); // 10:30 AM
        Time time2 = new TimeImpl(11, 30); // 11:30 AM

        // Act & Assert
        assertTrue(time1.compareTo(time2) < 0, "Expected compareTo to return a negative value when time1 is earlier");
    }

    @Test
    void testToStringMethod() {
        // Arrange
        Time time = new TimeImpl(10, 30); // 10:30 AM

        // Act
        String result = time.toString();

        // Assert
        assertEquals("10:30", result, "Expected string representation to be '10:30'");
    }
    @Test
    void testAddTimeWithPositiveMinutes() {
        // Arrange
        Time time = new TimeImpl(10, 0); // 10:00 AM

        // Act
        Time newTime = time.addTime(120); // Add 2 hours (120 minutes)

        // Assert
        assertEquals(12, newTime.getHours(), "Expected hours to be 12 after adding 120 minutes");
        assertEquals(0, newTime.getMinutes(), "Expected minutes to remain 0 after adding 120 minutes");
    }

    @Test
    void testAddTimeWithWrapAround() {
        // Arrange
        Time time = new TimeImpl(23, 0); // 11:00 PM

        // Act
        Time newTime = time.addTime(120); // Add 2 hours, should wrap to 01:00 AM

        // Assert
        assertEquals(1, newTime.getHours(), "Expected hours to be 1 after adding 120 minutes");
        assertEquals(0, newTime.getMinutes(), "Expected minutes to remain 0 after adding 120 minutes");
    }


    @Test
    void testConstructorWithValidTimeHours() {
        // Arrange
        int hours = 10;
        int minutes = 45;

        // Act
        Time time = new TimeImpl(hours, minutes);

        // Assert
        assertEquals(10, time.getHours(), "Expected hours to be 10");
    }

    @Test
    void testConstructorWithValidTimeMinutes() {
        // Arrange
        int hours = 10;
        int minutes = 45;

        // Act
        Time time = new TimeImpl(hours, minutes);

        // Assert
        assertEquals(45, time.getMinutes(), "Expected minutes to be 45");
    }

    @Test
    void testConstructorWithValidBoundaryTimeHours() {
        // Arrange
        int hours = 23;
        int minutes = 59;

        // Act
        Time time = new TimeImpl(hours, minutes);

        // Assert
        assertEquals(23, time.getHours(), "Expected hours to be 23");
    }

    @Test
    void testConstructorWithValidBoundaryTimeMinutes() {
        // Arrange
        int hours = 23;
        int minutes = 59;

        // Act
        Time time = new TimeImpl(hours, minutes);

        // Assert
        assertEquals(59, time.getMinutes(), "Expected minutes to be 59");
    }



    @Test
    void testConstructorWithNegativeMinutesNormalizedHours() {
        // Arrange
        int hours = 10;
        int minutes = -15;  // -15 minutes from 10:00 should result in 9:45

        // Act
        Time time = new TimeImpl(hours, minutes);

        // Assert
        assertEquals(9, time.getHours(), "Expected hours to be 9 after normalizing negative minutes");
    }

    @Test
    void testConstructorWithNegativeMinutesNormalizedMinutes() {
        // Arrange
        int hours = 10;
        int minutes = -15;  // -15 minutes from 10:00 should result in 9:45

        // Act
        Time time = new TimeImpl(hours, minutes);

        // Assert
        assertEquals(45, time.getMinutes(), "Expected minutes to be 45 after normalizing negative minutes");
    }



    @Test
    void testAddTimeWithMinutesWrapAroundHours() {
        // Arrange
        Time time = new TimeImpl(23, 30); // 11:30 PM

        // Act
        Time newTime = time.addTime(120); // Add 2 hours (should wrap to 01:30 AM)

        // Assert
        assertEquals(1, newTime.getHours(), "Expected hours to wrap around to 1 AM");
    }

    @Test
    void testAddTimeWithMinutesWrapAroundMinutes() {
        // Arrange
        Time time = new TimeImpl(23, 30); // 11:30 PM

        // Act
        Time newTime = time.addTime(120); // Add 2 hours (should wrap to 01:30 AM)

        // Assert
        assertEquals(30, newTime.getMinutes(), "Expected minutes to remain 30");
    }

    @Test
    void testAddTimeWithNegativeMinutesHours() {
        // Arrange
        Time time = new TimeImpl(2, 30); // 2:30 AM

        // Act
        Time newTime = time.addTime(-180); // Subtract 3 hours (should wrap to 11:30 PM)

        // Assert
        assertEquals(23, newTime.getHours(), "Expected hours to wrap around to 11 PM");
    }

    @Test
    void testAddTimeWithNegativeMinutesMinutes() {
        // Arrange
        Time time = new TimeImpl(2, 30); // 2:30 AM

        // Act
        Time newTime = time.addTime(-180); // Subtract 3 hours (should wrap to 11:30 PM)

        // Assert
        assertEquals(30, newTime.getMinutes(), "Expected minutes to remain 30");
    }

    @Test
    void testAddTimeWithAnotherTimeObjectHours() {
        // Arrange
        Time time1 = new TimeImpl(10, 30); // 10:30 AM
        Time time2 = new TimeImpl(3, 45); // 3:45 AM

        // Act
        Time result = time1.addTime(time2); // Adding 3:45 to 10:30

        // Assert
        assertEquals(14, result.getHours(), "Expected hours to be 14 (2:15 PM)");
    }

    @Test
    void testAddTimeWithAnotherTimeObjectMinutes() {
        // Arrange
        Time time1 = new TimeImpl(10, 30); // 10:30 AM
        Time time2 = new TimeImpl(3, 45); // 3:45 AM

        // Act
        Time result = time1.addTime(time2); // Adding 3:45 to 10:30

        // Assert
        assertEquals(15, result.getMinutes(), "Expected minutes to be 15");
    }



    @Test
    void testAddTimeWithPositiveMinutesHours() {
        // Arrange
        Time time = new TimeImpl(10, 0); // 10:00 AM

        // Act
        Time newTime = time.addTime(120); // Add 2 hours (120 minutes)

        // Assert
        assertEquals(12, newTime.getHours(), "Expected hours to be 12 after adding 120 minutes");
    }

    @Test
    void testAddTimeWithPositiveMinutesMinutes() {
        // Arrange
        Time time = new TimeImpl(10, 0); // 10:00 AM

        // Act
        Time newTime = time.addTime(120); // Add 2 hours (120 minutes)

        // Assert
        assertEquals(0, newTime.getMinutes(), "Expected minutes to remain 0 after adding 120 minutes");
    }

    @Test
    void testAddTimeWithWrapAroundHours() {
        // Arrange
        Time time = new TimeImpl(23, 0); // 11:00 PM

        // Act
        Time newTime = time.addTime(120); // Add 2 hours, should wrap to 01:00 AM

        // Assert
        assertEquals(1, newTime.getHours(), "Expected hours to be 1 after adding 120 minutes");
    }

    @Test
    void testAddTimeWithWrapAroundMinutes() {
        // Arrange
        Time time = new TimeImpl(23, 0); // 11:00 PM

        // Act
        Time newTime = time.addTime(120); // Add 2 hours, should wrap to 01:00 AM

        // Assert
        assertEquals(0, newTime.getMinutes(), "Expected minutes to remain 0 after adding 120 minutes");
    }

    @Test
    void testEqualsSameTime() {
        // Arrange
        TimeImpl time1 = new TimeImpl(10, 30);
        TimeImpl time2 = new TimeImpl(10, 30);

        // Act & Assert
        assertTrue(time1.equals(time2), "Expected both Time objects to be equal");
    }

    @Test
    void testEqualsDifferentTime() {
        // Arrange
        TimeImpl time1 = new TimeImpl(10, 30);
        TimeImpl time2 = new TimeImpl(11, 45);

        // Act & Assert
        assertFalse(time1.equals(time2), "Expected Time objects with different times to not be equal");
    }

    @Test
    void testEqualsNull() {
        // Arrange
        TimeImpl time1 = new TimeImpl(10, 30);

        // Act & Assert
        assertFalse(time1.equals(null), "Expected Time object to not be equal to null");
    }

    @Test
    void testEqualsDifferentType() {
        // Arrange
        TimeImpl time1 = new TimeImpl(10, 30);
        String someString = "Some String";

        // Act & Assert
        assertFalse(time1.equals(someString), "Expected Time object to not be equal to an object of a different type");
    }

    @Test
    void testEqualsSameInstance() {
        // Arrange
        TimeImpl time1 = new TimeImpl(10, 30);

        // Act & Assert
        assertTrue(time1.equals(time1), "Expected Time object to be equal to itself");
    }


    @Test
    void testConstructorWithNegativeMinutes() {
        // Arrange
        int hours = 10;
        int minutes = -1;  // -1 minute should wrap to the previous hour

        // Act
        Time time = new TimeImpl(hours, minutes);

        // Assert
        assertEquals(9, time.getHours(), "Expected hours to be 9 after wrapping negative minutes");
        assertEquals(59, time.getMinutes(), "Expected minutes to be 59 after wrapping negative minutes");
    }


    @Test
    void testConstructorWithTooManyMinutes() {
        // Arrange
        int hours = 10;
        int minutes = 60;  // 60 minutes should roll over into the next hour

        // Act
        Time time = new TimeImpl(hours, minutes);

        // Assert
        assertEquals(11, time.getHours(), "Expected hours to be 11 after rolling over 60 minutes");
        assertEquals(0, time.getMinutes(), "Expected minutes to be 0 after rolling over 60 minutes");
    }

    @Test
    void testConstructorWithNegativeHours() {
        // Arrange & Act & Assert
        assertThrows(IllegalArgumentException.class, () -> new TimeImpl(-1, 30),
                "Expected exception when hours are negative");
    }

    @Test
    void testConstructorWithTooManyHours() {
        // Arrange & Act & Assert
        assertThrows(IllegalArgumentException.class, () -> new TimeImpl(24, 0),
                "Expected exception when hours are greater than 23");
    }

    @Test
    void testConstructorWithEdgeTime() {
        // Arrange
        int hours = 23;
        int minutes = 59;

        // Act
        TimeImpl time = new TimeImpl(hours, minutes);

        // Assert
        assertEquals(23, time.getHours(), "Expected hours to be 23");
        assertEquals(59, time.getMinutes(), "Expected minutes to be 59");
    }

}
