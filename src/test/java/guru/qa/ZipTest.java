package guru.qa;

import com.codeborne.xlstest.XLS;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class ZipTest {
    @Test
    void TestForZip () throws IOException, ZipException {

        ZipFile zipFile = new ZipFile("src/test/resources/ZIP.zip");
        zipFile.setPassword("00000");
        zipFile.extractAll("src/test/resources/");

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader(); // Чтение файла из ресурсов через classLoader
        InputStream stream = classLoader.getResourceAsStream("XLS.xls"); // Чтение тестового файла
        XLS xlsFile = new XLS(stream);
        Assertions.assertEquals("bbb222", xlsFile.excel.getSheetAt(0).getRow(1).getCell(1).getStringCellValue());
    }
}
