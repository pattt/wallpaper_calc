package org.wallpaper.calc.processors;

import org.junit.jupiter.api.Test;
import org.wallpaper.calc.Room;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CubicShapeRoomsProcessorTest {

    List<Room> rooms = List.of(
        new Room(1,2,3),
        new Room(1,1,1),
        new Room(1,1,5),
        new Room(15,15,15)
    );

    @Test
    void process() {
        List<Room> expected = List.of(
            new Room(15,15,15),
            new Room(1,1,1)

        );
        CubicShapeRoomsProcessor processor = new CubicShapeRoomsProcessor();
        List<Room> actual = processor.process(rooms).toList();
        assertEquals(expected, actual);
    }
}