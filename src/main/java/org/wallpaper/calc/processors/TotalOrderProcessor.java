package org.wallpaper.calc.processors;

import org.wallpaper.calc.Room;

import java.util.List;

/**
 * calculates number of total square feet of wallpaper the company should order for all rooms
 */
public class TotalOrderProcessor implements Processor<Integer>{

    @Override
    public Integer process(List<Room> rooms) {
        return rooms.stream().map(Room::getRequiredSquare).reduce(0, Integer::sum);
    }
}
