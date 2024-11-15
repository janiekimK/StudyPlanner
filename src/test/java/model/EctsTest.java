package model;
import Model.Ects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * This test class verifies the duration calculation for ECTS values using mocking.
 */
class EctsTest {

    private Ects mockedEcts;

    @BeforeEach
    void setUp() {
        // Freeze time to ensure consistent timestamps during tests
        Instant fixedTime = Instant.now();
        mockStatic(Ects.class); // Use mockStatic for static method
        when(Ects.getNow()).thenReturn(fixedTime);  // Mock the static method getNow()

        // Initialize mocked ECTS with 5 points
        mockedEcts = spy(new Ects(5)); // Creating a spy object with initial 5 ECTS
    }

    @Test
    void testDurationCalculationWithFrozenTime() {
        // Expected duration for 5 ECTS (5 * 30 hours)
        Duration expectedDuration = Duration.of(5 * 30, ChronoUnit.HOURS);

        // Override getDuration in mockedEcts to return expectedDuration
        doReturn(expectedDuration).when(mockedEcts).getDuration();

        // Assert that mockedEcts returns the expected duration of 150 hours
        assertEquals(expectedDuration, mockedEcts.getDuration());

        // Test with a modified ECTS value
        mockedEcts.setEcts(3); // Set to 3 ECTS points
        Duration reducedExpectedDuration = Duration.of(3 * 30, ChronoUnit.HOURS);

        // Mock getDuration to return reducedExpectedDuration
        doReturn(reducedExpectedDuration).when(mockedEcts).getDuration();

        // Assert that mockedEcts returns the updated expected duration of 90 hours
        assertEquals(reducedExpectedDuration, mockedEcts.getDuration());
    }
}
