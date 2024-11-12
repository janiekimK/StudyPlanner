import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

class ModulTest {
    private Modul mockedModul;

    @BeforeEach
        // Mock Objekt von Modul
    void setUp() {
        mockedModul = Mockito.spy(new Modul("Testmodul", 5));
    }

    @Test
        // Testet ob getId den erwarteten Wert gibt
    void testGetId() {
        when(mockedModul.getId()).thenReturn("123456");
        assertEquals("123456", mockedModul.getId());
    }

    @Test
        // Testet ob getUuid die erwartete Liste zurückgibt
    void testGetUuid() {
        List<String> expectedUuids = Arrays.asList("ListTest1", "ListTest2", "ListTest3");
        when(mockedModul.getUuid()).thenReturn(expectedUuids);
        assertEquals(expectedUuids, mockedModul.getUuid());
    }

    @Test
        // Testet ob GetModulname den erwarteten Modulnamen zurückgibt
    void testGetModulname() {
        when(mockedModul.getModulname()).thenReturn("Testmodul1");
        assertEquals("Testmodul1", mockedModul.getModulname());
    }

    @Test
        // Testet ob setModulname() den Modulnamen setzt und die getModulname() den neuen Wert zurückgibt
    void testSetModulname() {
        mockedModul.setModulname("Testmodulname");
        assertEquals("Testmodulname", mockedModul.getModulname());
    }

    @Test
        // Testet ob gettEcts() den erwarteten Wert für die ECTS-Punkte zurückgibt
    void testGetEcts() {
        when(mockedModul.gettEcts()).thenReturn(5);
        assertEquals(5, mockedModul.gettEcts());
    }
}