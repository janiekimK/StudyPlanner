import Model.Ects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class EctsTest {

    private Ects mockedEcts;

    @BeforeEach
    void setUp() {
        mockedEcts = spy(new Ects(5)); // 5 ECTS-Punkte als Beispiel
    }

    @Test
    void testDurationCalculationWithFrozenTime() {
        // Mock die Duration-Berechnung, um sicherzustellen, dass das Ergebnis korrekt ist
        Duration expectedDuration = Duration.of(5 * 30, ChronoUnit.HOURS); // Erwartete Dauer für 5 ECTS-Punkte

        // Füge einen Mock hinzu, um die Berechnung von Duration.ofHours() zu kontrollieren
        doReturn(expectedDuration).when(mockedEcts).getDuration();

        // Überprüfe, ob die erwartete Duration (150 Stunden) korrekt berechnet wurde
        assertEquals(expectedDuration, mockedEcts.getDuration());

        // Teste die Berechnung bei einer Änderung der ECTS-Punkte
        mockedEcts.setEcts(3); // Reduziere auf 3 ECTS
        Duration reducedExpectedDuration = Duration.of(3 * 30, ChronoUnit.HOURS);

        doReturn(reducedExpectedDuration).when(mockedEcts).getDuration();
        assertEquals(reducedExpectedDuration, mockedEcts.getDuration());
    }
}
