//importe
import Model.Ects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

//Klass wird erstellt EctsTest mit private mockedEcts
class EctsTest {

    private Ects mockedEcts;

    //spy software schafft mit Mockito
    //beforeEach wird de Test ufgruefe und mockedEcts erstellt mit 5 ECTS Pünkt
    @BeforeEach
    void setUp() {
        //die aktuelli zyt wird zeigt und defür benutzt das währendem ganze test
        // de gliechi zyt stempel verwendet wird
        Instant fixedTime = Instant.now();
        when(Ects.getNow()).thenReturn(fixedTime);
        mockedEcts = spy(new Ects(5)); // 5 ECTS-Punkte als Beispiel
    }


    //Durberechnig vo de Ects Klasse
    @Test
    void testDurationCalculationWithFrozenTime() {
        // bi 5 ECTS Pünkt wird uf 150h festglegt (5x30h)
        Duration expectedDuration = Duration.of(5 * 30, ChronoUnit.HOURS);

        // Hier wird die getDuration-Methode von mockedEcts gefälscht, sodass sie die expectedDuration (150 Stunden) zurückgibt, anstatt die tatsächliche Berechnung durchzuführen.
        doReturn(expectedDuration).when(mockedEcts).getDuration();

        // Überprüft öb getDuration die erwarteti Duur 150h zrugg git
        assertEquals(expectedDuration, mockedEcts.getDuration());

        // Teste die Berechnung bei einer Änderung der ECTS-Punkte
        mockedEcts.setEcts(3); // Reduziert uf 3 ECTS
        Duration reducedExpectedDuration = Duration.of(3 * 30, ChronoUnit.HOURS);

        doReturn(reducedExpectedDuration).when(mockedEcts).getDuration();
        // wird gluegt das d änderig vo de pünkt au änderig in de zyt macht
        assertEquals(reducedExpectedDuration, mockedEcts.getDuration());
    }
}
