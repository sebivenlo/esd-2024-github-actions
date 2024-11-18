package simpletime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import simpletimeapi.Duration;
import simpletimeapi.Time;
import simpletimeimpl.DurationImpl;
import simpletimeimpl.TimeImpl;

import static org.junit.jupiter.api.Assertions.*;

class SimpleTimeFactoryTest {

    private SimpleTimeFactory factory;

    @BeforeEach
    void setUp() {
        factory = new SimpleTimeFactory();
    }

    // Tests for createTime method

    @Test
    void testCreateTimeWithValidTimeReturnsNonNull() {
        // Act
        Time time = factory.createTime(10, 30);

        // Assert
        assertNotNull(time, "Expected a non-null Time object");
    }

    @Test
    void testCreateTimeWithValidTimeReturnsCorrectInstance() {
        // Act
        Time time = factory.createTime(10, 30);

        // Assert
        assertTrue(time instanceof TimeImpl, "Expected Time object to be an instance of TimeImpl");
    }

    @Test
    void testCreateTimeReturnsCorrectHours() {
        // Act
        Time time = factory.createTime(10, 30);

        // Assert
        assertEquals(10, time.getHours(), "Expected hours to be 10");
    }

    @Test
    void testCreateTimeReturnsCorrectMinutes() {
        // Act
        Time time = factory.createTime(10, 30);

        // Assert
        assertEquals(30, time.getMinutes(), "Expected minutes to be 30");
    }

    @Test
    void testCreateTimeWithExcessiveMinutesReturnsCorrectHours() {
        // Act
        Time time = factory.createTime(10, 90); // 90 minutes = 1 hour and 30 minutes

        // Assert
        assertEquals(11, time.getHours(), "Expected hours to be 11 after normalizing 90 minutes");
    }

    @Test
    void testCreateTimeWithExcessiveMinutesReturnsCorrectMinutes() {
        // Act
        Time time = factory.createTime(10, 90); // 90 minutes = 1 hour and 30 minutes

        // Assert
        assertEquals(30, time.getMinutes(), "Expected minutes to be 30 after normalizing 90 minutes");
    }

    @Test
    void testCreateTimeWithNegativeMinutesReturnsCorrectHours() {
        // Act
        Time time = factory.createTime(10, -30); // Negative minutes should wrap around

        // Assert
        assertEquals(9, time.getHours(), "Expected hours to be 9 after wrapping negative minutes");
    }

    @Test
    void testCreateTimeWithNegativeMinutesReturnsCorrectMinutes() {
        // Act
        Time time = factory.createTime(10, -30); // Negative minutes should wrap around

        // Assert
        assertEquals(30, time.getMinutes(), "Expected minutes to be 30 after wrapping negative minutes");
    }

    // Tests for createDuration with hours and minutes

    @Test
    void testCreateDurationWithValidValuesReturnsNonNull() {
        // Act
        Duration duration = factory.createDuration(2, 45);

        // Assert
        assertNotNull(duration, "Expected a non-null Duration object");
    }

    @Test
    void testCreateDurationWithValidValuesReturnsCorrectInstance() {
        // Act
        Duration duration = factory.createDuration(2, 45);

        // Assert
        assertTrue(duration instanceof DurationImpl, "Expected Duration object to be an instance of DurationImpl");
    }

    @Test
    void testCreateDurationReturnsCorrectHours() {
        // Act
        Duration duration = factory.createDuration(2, 45);

        // Assert
        assertEquals(2, duration.getHours(), "Expected hours to be 2");
    }

    @Test
    void testCreateDurationReturnsCorrectMinutes() {
        // Act
        Duration duration = factory.createDuration(2, 45);

        // Assert
        assertEquals(45, duration.getMinutes(), "Expected minutes to be 45");
    }

    @Test
    void testCreateDurationWithExcessiveMinutesReturnsCorrectHours() {
        // Act
        Duration duration = factory.createDuration(1, 120); // 120 minutes = 2 hours

        // Assert
        assertEquals(3, duration.getHours(), "Expected hours to be 3 after normalizing 120 minutes");
    }

    @Test
    void testCreateDurationWithExcessiveMinutesReturnsCorrectMinutes() {
        // Act
        Duration duration = factory.createDuration(1, 120); // 120 minutes = 2 hours

        // Assert
        assertEquals(0, duration.getMinutes(), "Expected minutes to be 0 after normalizing 120 minutes");
    }

    // Tests for createDuration with total minutes

    @Test
    void testCreateDurationFromTotalMinutesReturnsNonNull() {
        // Act
        Duration duration = factory.createDuration(185); // 185 minutes = 3 hours and 5 minutes

        // Assert
        assertNotNull(duration, "Expected a non-null Duration object");
    }

    @Test
    void testCreateDurationFromTotalMinutesReturnsCorrectInstance() {
        // Act
        Duration duration = factory.createDuration(185); // 185 minutes = 3 hours and 5 minutes

        // Assert
        assertTrue(duration instanceof DurationImpl, "Expected Duration object to be an instance of DurationImpl");
    }

    @Test
    void testCreateDurationFromTotalMinutesReturnsCorrectHours() {
        // Act
        Duration duration = factory.createDuration(185); // 185 minutes = 3 hours and 5 minutes

        // Assert
        assertEquals(3, duration.getHours(), "Expected hours to be 3");
    }

    @Test
    void testCreateDurationFromTotalMinutesReturnsCorrectMinutes() {
        // Act
        Duration duration = factory.createDuration(185); // 185 minutes = 3 hours and 5 minutes

        // Assert
        assertEquals(5, duration.getMinutes(), "Expected minutes to be 5");
    }
}
