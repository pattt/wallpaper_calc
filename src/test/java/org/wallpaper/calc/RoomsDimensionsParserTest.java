package org.wallpaper.calc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.wallpaper.calc.exceptions.RoomDimensionsFormatException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RoomsDimensionsParserTest {

    @Test
    void parse() {
        var expected = List.of(
            new Room(1, 2, 3),
            new Room(1, 1, 5)
        );

        try( MockedStatic<Files> files = Mockito.mockStatic(Files.class) ) {
            files.when(() -> Files.lines(Mockito.any(Path.class))).thenReturn(Stream.of("1x2x3", "1x1x5"));
            assertEquals(expected, RoomsDimensionsParser.parse(""));
        }
    }

    @Test
    void parseException() {
        try (MockedStatic<Files> files = Mockito.mockStatic(Files.class)) {
            files.when(() -> Files.lines(Mockito.any(Path.class))).thenReturn(Stream.of("1x2", "1x1x5"));

            RoomDimensionsFormatException exception = Assertions.assertThrows(RoomDimensionsFormatException.class,
                () -> RoomsDimensionsParser.parse("")
            );

            assertEquals("java.lang.ArrayIndexOutOfBoundsException: Index 2 out of bounds for length 2", exception.getMessage());
        }
    }
}