package org.wallpaper.calc.processors;

import org.wallpaper.calc.Room;

import java.util.List;

public interface Processor<T> {
    T process(List<Room> rooms);
}
