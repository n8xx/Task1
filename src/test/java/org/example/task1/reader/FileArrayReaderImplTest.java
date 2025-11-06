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

        Path fileInResources = resourceDir.resolve("testFile.txt");
        Files.write(fileInResources, List.of("1; 2; 3", "4; 5; 6"));

        Path buildResourceDir = Path.of("build", "resources", "test");
        Files.createDirectories(buildResourceDir);
        Files.copy(fileInResources, buildResourceDir.resolve("testFile.txt"), java.nio.file.StandardCopyOption.REPLACE_EXISTING);

        List<String> lines = reader.readFromFile("testFile.txt");

        assertAll(
                () -> assertEquals(2, lines.size()),
                () -> assertEquals("1; 2; 3", lines.get(0)),
                () -> assertEquals("4; 5; 6", lines.get(1))
        );
    }

    @Test
    @DisplayName("File not found - throw ArrayException")
    void testFileNotFoundThrowsException() {
        FileArrayReader reader = new FileArrayReaderImpl();
        ArrayException exception = assertThrows(ArrayException.class, () ->
                reader.readFile("no_such_file.txt")
        );

        assertTrue(exception.getMessage().contains("File not found"));
    }

    @Test
    @DisplayName("wrong uri - throw ArrayException")
    void testUriSyntaxExceptionHandling() {
        FileArrayReaderImpl reader = new FileArrayReaderImpl();

        assertThrows(ArrayException.class, () -> {
            reader.readFile("%:/broken_uri.txt");
        });
    }
}