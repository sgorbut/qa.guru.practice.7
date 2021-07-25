package guru.qa;

import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class XlsTest {

    @Test
    void TestForXLS() throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader(); // Чтение файла из ресурсов через classLoader
        InputStream stream = classLoader.getResourceAsStream("XLS.xls"); // Чтение тестового файла
        XLS xlsFile = new XLS(stream);
        Assertions.assertEquals("bbb222", xlsFile.excel.getSheetAt(0).getRow(1).getCell(1).getStringCellValue());
    }

}
