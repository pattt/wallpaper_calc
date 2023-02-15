package org.wallpaper.calc.processors;

import org.wallpaper.calc.Room;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class CubicShapeRoomsProcessor implements Processor<Stream<Room>> {
    @Override
    public Stream<Room> process(List<Room> rooms) {
        return rooms.stream()
            .sorted(Comparator.comparingInt(Room::getRequiredSquare).reversed())
            .filter(Room::isCubic);
    }
}
