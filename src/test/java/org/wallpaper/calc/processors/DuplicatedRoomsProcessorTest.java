package org.wallpaper.calc.processors;

import org.junit.jupiter.api.Test;
import org.wallpaper.calc.Room;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DuplicatedRoomsProcessorTest {

    List<Room> rooms = List.of(
        new Room(1,2,3),
        new Room(1,1,5),
        new Room(15,15,15),
        new Room(1,1,5)
    );

    @Test
    void process() {
        List<Room> expected = List.of(
            new Room(1,1,5)
        );
        DuplicatedRoomsProcessor processor = new DuplicatedRoomsProcessor();
        List<Room> actual = processor.process(rooms).toList();
        assertEquals(expected, actual);
    }
}