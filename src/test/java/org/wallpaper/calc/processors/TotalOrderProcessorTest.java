package org.wallpaper.calc.processors;

import org.junit.jupiter.api.Test;
import org.wallpaper.calc.Room;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TotalOrderProcessorTest {

    List<Room> rooms = List.of(
        new Room(1, 2, 3),
        new Room(1, 1, 5)
    );

    @Test
    void process() {
        var processor = new TotalOrderProcessor();
        var actual = processor.process(rooms);
        assertEquals(47, actual);
    }
}