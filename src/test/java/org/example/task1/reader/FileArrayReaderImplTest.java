package org.example.task1.reader;

import org.example.task1.exception.ArrayException;
import org.example.task1.io.reader.impl.ArrayReaderService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileArrayReaderImplTest {

    @Test
    @DisplayName("Right file reading")
    void testReadFileSuccessfully() throws Exception {
        ArrayReaderService reader = new ArrayReaderService();

        Path resourceDir = Path.of("src", "test", "resources");
        Files.createDirectories(resourceDir);

        Path testFile = resourceDir.resolve("testFile.txt");
        Files.write(testFile, List.of("1; 2; 3", "4; 5; 6"));

        List<String> lines = reader.readFromFile(testFile.toAbsolutePath().toString());

        assertAll(
                () -> assertEquals(2, lines.size()),
                () -> assertEquals("1; 2; 3", lines.get(0)),
                () -> assertEquals("4; 5; 6", lines.get(1))
        );
    }

    @Test
    @DisplayName("File not found - throw ArrayException")
    void testFileNotFoundThrowsException() {
        ArrayReaderService reader = new ArrayReaderService();
        ArrayException exception = assertThrows(ArrayException.class, () ->
                reader.readFromFile("no_such_file.txt")
        );

        assertTrue(exception.getMessage().contains("File not found"));
    }

    @Test
    @DisplayName("wrong uri - throw ArrayException")
    void testUriSyntaxExceptionHandling() {
        ArrayReaderService reader = new ArrayReaderService();

        assertThrows(ArrayException.class, () -> {
            reader.readFromFile("%:/broken_uri.txt");
        });
    }
}