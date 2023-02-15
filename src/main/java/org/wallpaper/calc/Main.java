package org.wallpaper.calc;

import org.wallpaper.calc.processors.CubicShapeRoomsProcessor;
import org.wallpaper.calc.processors.DuplicatedRoomsProcessor;
import org.wallpaper.calc.processors.TotalOrderProcessor;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("No path argument provided");
            System.exit(1);
        }

        List<Room> rooms = RoomsDimensionsParser.parse(args[0]);

        Printer printer = new Printer(rooms);

        List.of(
            new TotalOrderProcessor(),
            new CubicShapeRoomsProcessor(),
            new DuplicatedRoomsProcessor()
        ).forEach(printer::print);

    }
}