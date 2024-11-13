package View;

import org.junit.jupiter.api.Test;

import javafx.scene.text.Text;
import javafx.stage.Stage;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class ShowQuotesTest {
    @Test
    void testShowQuotesWithTimestamp() {
        // Arrange
        ShowQuotes showQuotes = new ShowQuotes();

        // Act
        showQuotes.showQuotes();

        // Assert
        // Überprüfen Sie, dass die Zitat-Anzeige den aktuellen Zeitstempel enthält
        Stage stage = (Stage) showQuotes.getScene().getWindow();
        Text quoteText = (Text) stage.getScene().lookup("Text");
        assertNotNull(quoteText);
        assertTrue(quoteText.getText().contains(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"))));

        // Cleanup
        stage.close();
    }
}
