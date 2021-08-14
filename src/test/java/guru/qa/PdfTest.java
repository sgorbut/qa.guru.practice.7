package guru.qa;

import com.codeborne.pdftest.PDF;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import static org.assertj.core.api.Assertions.assertThat;
import static com.codeborne.pdftest.PDF.containsText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.MatcherAssert.assertThat;

public class PdfTest {

    @Test
    void testForPdf() throws IOException, IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader(); // Чтение файла из ресурсов через classLoader
        InputStream stream = classLoader.getResourceAsStream("PDF.pdf"); // Чтение тестового файла
        PDF pdfFile = new PDF(stream);
        assertThat(pdfFile.creator).contains("LibreOffice 6.4.7.2");
    }
}
