package org.wallpaper.calc.processors;

import org.wallpaper.calc.Room;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class DuplicatedRoomsProcessor implements Processor<Stream<Room>> {
    @Override
    public Stream<Room> process(List<Room> rooms) {
        Set<Room> items = new HashSet<>();
        return rooms.stream().filter(room -> !items.add(room))/*.forEach(System.out::println)*/;
    }
}
