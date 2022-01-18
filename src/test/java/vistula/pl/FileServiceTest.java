package vistula.pl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import pl.vistula.exception.FileFormatException;
import pl.vistula.model.ConvertFileRequest;
import pl.vistula.service.FileService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileServiceTest {

    @TempDir
    Path tempDir;

    Path txtFilePath;

    @BeforeEach
    void createTxtFile() throws IOException {
        txtFilePath = tempDir.resolve("cars.txt");
        Files.write(txtFilePath, "2021/01/10\t08:20:30 PM\t11.51\t11.51\tGood Car".getBytes());
    }

    @Test
    void testConvertToCsv() throws IOException {
        Path csvFilePath = tempDir.resolve("cars");

        ConvertFileRequest request = new ConvertFileRequest();
        request.setFileFormat("csv");
        request.setSourceFile(txtFilePath.toString());
        request.setDestinationFile(csvFilePath.toString());

        FileService.convertAndSaveFile(request);

        File file = new File(csvFilePath + ".csv");
        assertTrue(file.exists());
    }

    @Test
    void testConvertToXml() throws IOException {
        Path xmlFilePath = tempDir.resolve("cars");

        ConvertFileRequest request = new ConvertFileRequest();
        request.setFileFormat("xml");
        request.setSourceFile(txtFilePath.toString());
        request.setDestinationFile(xmlFilePath.toString());

        FileService.convertAndSaveFile(request);

        File file = new File(xmlFilePath + ".xml");
        assertTrue(file.exists());
    }

    @Test
    void testInvalidFileFormatException() {
        Path pdfFilePath = tempDir.resolve("cars");

        ConvertFileRequest request = new ConvertFileRequest();
        request.setFileFormat("pdf");
        request.setSourceFile(txtFilePath.toString());
        request.setDestinationFile(pdfFilePath.toString());

        Assertions.assertThrows(
                FileFormatException.class,
                () -> FileService.convertAndSaveFile(request)
        );
    }
}
