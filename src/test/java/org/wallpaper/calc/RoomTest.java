package org.wallpaper.calc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RoomTest {

    private final Room room1 = new Room(1, 2, 3);
    private final Room room2 = new Room(1, 1, 5);
    private final Room cubicRoom = new Room(5, 5, 5);

    @Test
    void getSquare() {
        assertEquals(22, room1.getSquare());
        assertEquals(22, room2.getSquare());
    }

    @Test
    void getAdditionalSquare() {
        assertEquals(2, room1.getAdditionalSquare());
        assertEquals(1, room2.getAdditionalSquare());
    }

    @Test
    void getRequiredSquare() {
        assertEquals(24, room1.getRequiredSquare());
        assertEquals(23, room2.getRequiredSquare());
    }

    @Test
    void isCubic() {
        assertTrue(cubicRoom.isCubic());
        assertFalse(room1.isCubic());
    }

    @Test
    void getName() {
        assertEquals("1x2x3", room1.getName());
        assertEquals("1x1x5", room2.getName());
    }
}