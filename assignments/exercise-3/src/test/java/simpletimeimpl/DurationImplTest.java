package simpletimeimpl;

import org.junit.jupiter.api.Test;
import simpletimeapi.Duration;

import static org.junit.jupiter.api.Assertions.*;

class DurationImplTest {

    @Test
    void testConstructorWithTotalMinutesForHours() {
        // Arrange
        int totalMinutes = 150;  // 150 minutes = 2 hours and 30 minutes

        // Act
        Duration duration = new DurationImpl(totalMinutes);

        // Assert
        assertEquals(2, duration.getHours(), "Expected 2 hours from 150 minutes");
    }

    @Test
    void testConstructorWithTotalMinutesForMinutes() {
        // Arrange
        int totalMinutes = 150;  // 150 minutes = 2 hours and 30 minutes

        // Act
        Duration duration = new DurationImpl(totalMinutes);

        // Assert
        assertEquals(30, duration.getMinutes(), "Expected 30 minutes from 150 minutes");
    }

    @Test
    void testConstructorWithTotalMinutesForAsMinutes() {
        // Arrange
        int totalMinutes = 150;  // 150 minutes = 2 hours and 30 minutes

        // Act
        Duration duration = new DurationImpl(totalMinutes);

        // Assert
        assertEquals(150, duration.asMinutes(), "Expected total of 150 minutes");
    }

    @Test
    void testConstructorWithHoursAndMinutesForHours() {
        // Arrange
        int hours = 1;
        int minutes = 45;  // 1 hour and 45 minutes = 105 minutes

        // Act
        Duration duration = new DurationImpl(hours, minutes);

        // Assert
        assertEquals(1, duration.getHours(), "Expected 1 hour from input of 1 hour 45 minutes");
    }

    @Test
    void testConstructorWithHoursAndMinutesForMinutes() {
        // Arrange
        int hours = 1;
        int minutes = 45;  // 1 hour and 45 minutes = 105 minutes

        // Act
        Duration duration = new DurationImpl(hours, minutes);

        // Assert
        assertEquals(45, duration.getMinutes(), "Expected 45 minutes from input of 1 hour 45 minutes");
    }

    @Test
    void testConstructorWithHoursAndMinutesForAsMinutes() {
        // Arrange
        int hours = 1;
        int minutes = 45;  // 1 hour and 45 minutes = 105 minutes

        // Act
        Duration duration = new DurationImpl(hours, minutes);

        // Assert
        assertEquals(105, duration.asMinutes(), "Expected total of 105 minutes from 1 hour 45 minutes");
    }

    @Test
    void testAsMinutes() {
        // Arrange
        int hours = 3;
        int minutes = 20;  // 3 hours and 20 minutes = 200 minutes

        // Act
        Duration duration = new DurationImpl(hours, minutes);

        // Assert
        assertEquals(200, duration.asMinutes(), "Expected 200 total minutes from 3 hours 20 minutes");
    }

    @Test
    void testGetHours() {
        // Arrange
        int totalMinutes = 200;  // 200 minutes = 3 hours and 20 minutes

        // Act
        Duration duration = new DurationImpl(totalMinutes);

        // Assert
        assertEquals(3, duration.getHours(), "Expected 3 hours from 200 total minutes");
    }

    @Test
    void testGetMinutes() {
        // Arrange
        int totalMinutes = 200;  // 200 minutes = 3 hours and 20 minutes

        // Act
        Duration duration = new DurationImpl(totalMinutes);

        // Assert
        assertEquals(20, duration.getMinutes(), "Expected 20 minutes from 200 total minutes");
    }

    @Test
    void testPlusForHours() {
        // Arrange
        Duration duration1 = new DurationImpl(1, 30);  // 1 hour 30 minutes
        Duration duration2 = new DurationImpl(2, 15);  // 2 hours 15 minutes

        // Act
        Duration result = duration1.plus(duration2);  // Should sum to 3 hours 45 minutes (225 minutes)

        // Assert
        assertEquals(3, result.getHours(), "Expected 3 hours from sum of 1:30 and 2:15");
    }

    @Test
    void testPlusForMinutes() {
        // Arrange
        Duration duration1 = new DurationImpl(1, 30);  // 1 hour 30 minutes
        Duration duration2 = new DurationImpl(2, 15);  // 2 hours 15 minutes

        // Act
        Duration result = duration1.plus(duration2);  // Should sum to 3 hours 45 minutes (225 minutes)

        // Assert
        assertEquals(45, result.getMinutes(), "Expected 45 minutes from sum of 1:30 and 2:15");
    }

    @Test
    void testPlusForAsMinutes() {
        // Arrange
        Duration duration1 = new DurationImpl(1, 30);  // 1 hour 30 minutes
        Duration duration2 = new DurationImpl(2, 15);  // 2 hours 15 minutes

        // Act
        Duration result = duration1.plus(duration2);  // Should sum to 3 hours 45 minutes (225 minutes)

        // Assert
        assertEquals(225, result.asMinutes(), "Expected total of 225 minutes from sum of 1:30 and 2:15");
    }

    @Test
    void testToString() {
        // Arrange
        int totalMinutes = 125;  // 125 minutes

        // Act
        Duration duration = new DurationImpl(totalMinutes);

        // Assert
        assertEquals("125 minutes", duration.toString(), "Expected '125 minutes' as the string representation");
    }

    @Test
    void testEqualsSameObject() {
        // Arrange
        Duration duration = new DurationImpl(1, 30);  // 1 hour 30 minutes

        // Act & Assert
        assertTrue(duration.equals(duration), "Expected object to be equal to itself");
    }

    @Test
    void testEqualsDifferentObjectSameValues() {
        // Arrange
        Duration duration1 = new DurationImpl(1, 30);  // 1 hour 30 minutes
        Duration duration2 = new DurationImpl(1, 30);  // Another instance with the same values

        // Act & Assert
        assertTrue(duration1.equals(duration2), "Expected two Duration instances with the same values to be equal");
    }

    @Test
    void testHashCodeForSameValues() {
        // Arrange
        Duration duration1 = new DurationImpl(1, 30);  // 1 hour 30 minutes
        Duration duration2 = new DurationImpl(1, 30);  // Another instance with the same values

        // Act & Assert
        assertEquals(duration1.hashCode(), duration2.hashCode(), "Expected hash codes to be the same for equal Duration objects");
    }

    @Test
    void testEqualsDifferentObjectDifferentValues() {
        // Arrange
        Duration duration1 = new DurationImpl(1, 30);  // 1 hour 30 minutes
        Duration duration2 = new DurationImpl(2, 45);  // 2 hours 45 minutes

        // Act & Assert
        assertFalse(duration1.equals(duration2), "Expected two Duration objects with different values to not be equal");
    }

    @Test
    void testEqualsWithNull() {
        // Arrange
        Duration duration = new DurationImpl(1, 30);  // 1 hour 30 minutes

        // Act & Assert
        assertFalse(duration.equals(null), "Expected a Duration to not be equal to null");
    }

    @Test
    void testEqualsWithDifferentType() {
        // Arrange
        Duration duration = new DurationImpl(1, 30);  // 1 hour 30 minutes

        // Act & Assert
        assertFalse(duration.equals("1:30"), "Expected a Duration object to not equal an object of a different type");
    }

    @Test
    void testHashCodeConsistency() {
        // Arrange
        Duration duration = new DurationImpl(1, 30);  // 1 hour 30 minutes

        // Act
        int hashCode1 = duration.hashCode();
        int hashCode2 = duration.hashCode();

        // Assert
        assertEquals(hashCode1, hashCode2, "Expected hash code to remain consistent across multiple invocations");
    }

    @Test
    void testCompareToSameDuration() {
        // Arrange
        Duration duration1 = new DurationImpl(90);  // 90 minutes
        Duration duration2 = new DurationImpl(90);  // Another instance with 90 minutes

        // Act & Assert
        assertEquals(0, duration1.compareTo(duration2), "Expected comparison of two equal durations to return 0");
    }

    @Test
    void testCompareToLongerDuration() {
        // Arrange
        Duration duration1 = new DurationImpl(1, 30);  // 1 hour 30 minutes
        Duration duration2 = new DurationImpl(2, 0);   // 2 hours

        // Act & Assert
        assertTrue(duration1.compareTo(duration2) < 0, "Expected comparison of a shorter duration to return a negative value");
    }

    @Test
    void testCompareToShorterDuration() {
        // Arrange
        Duration duration1 = new DurationImpl(2, 30);  // 2 hours 30 minutes
        Duration duration2 = new DurationImpl(2, 0);   // 2 hours

        // Act & Assert
        assertTrue(duration1.compareTo(duration2) > 0, "Expected comparison of a longer duration to return a positive value");
    }

    @Test
    void testPlusWithNegativeDurationForHours() {
        // Arrange
        Duration duration1 = new DurationImpl(1, 30);  // 1 hour 30 minutes
        Duration negativeDuration = new DurationImpl(-30); // -30 minutes

        // Act
        Duration result = duration1.plus(negativeDuration); // 1 hour

        // Assert
        assertEquals(1, result.getHours(), "Expected hours to be 1 after subtracting 30 minutes");
    }
    @Test
    void testPlusWithNegativeDurationForMinutes() {
        // Arrange
        Duration duration1 = new DurationImpl(1, 30);  // 1 hour 30 minutes
        Duration negativeDuration = new DurationImpl(-30); // -30 minutes

        // Act
        Duration result = duration1.plus(negativeDuration); // 1 hour

        // Assert
        assertEquals(0, result.getMinutes(), "Expected minutes to be 0 after subtracting 30 minutes");
    }

}
