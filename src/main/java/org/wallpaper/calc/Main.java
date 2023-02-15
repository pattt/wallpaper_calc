package org.wallpaper.calc;

import org.wallpaper.calc.processors.CubicShapeRoomsProcessor;
import org.wallpaper.calc.processors.DuplicatedRoomsProcessor;
import org.wallpaper.calc.processors.TotalOrderProcessor;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Room> rooms = RoomsDementionsParser.parse("/Users/Pavlo_Avdyeyev/Downloads/wallpaper-calculator-main/sample-input.txt");

        Printer printer = new Printer(rooms);

        List.of(
            new TotalOrderProcessor(),
            new CubicShapeRoomsProcessor(),
            new DuplicatedRoomsProcessor()
        ).forEach(printer::print);

    }
}