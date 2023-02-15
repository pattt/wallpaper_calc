package org.wallpaper.calc;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.wallpaper.calc.processors.CubicShapeRoomsProcessor;
import org.wallpaper.calc.processors.DuplicatedRoomsProcessor;
import org.wallpaper.calc.processors.Processor;
import org.wallpaper.calc.processors.TotalOrderProcessor;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

@RequiredArgsConstructor
public class Printer {

    private final List<Room> roomList;

    private final BiConsumer<TotalOrderProcessor, List<Room>> totalOrderProcessorConsumer = (processor, rooms) -> {
        Integer totalCount = processor.process(rooms);
        String result = String.format(
            "%s-== The number of total square feet of wallpaper the company should order for all rooms is %d ==-",
            System.lineSeparator(),
            totalCount);
        System.out.println(result);
    };

    private final BiConsumer<CubicShapeRoomsProcessor, List<Room>> cubicShapeRoomsProcessorConsumer = (processor, rooms) -> {
        System.out.println(System.lineSeparator() +
            "-== rooms that have a cubic shape (order by total needed wallpaper descending) ==-");
        processor.process(rooms).forEach(room -> System.out.println(
            StringUtils.rightPad(room.getName(), 8, " ") + " | " + room.getRequiredSquare()));
    };

    private final BiConsumer<DuplicatedRoomsProcessor, List<Room>> duplicatedRoomsProcessorConsumer = (processor, rooms) -> {
        System.out.println(System.lineSeparator() + "-== rooms that are appearing more than once ==-");
        processor.process(rooms).map(Room::getName).forEach(System.out::println);
    };

    private final Map<? super Processor<?>, ? extends BiConsumer<?,?>> processors = Map.of(
        TotalOrderProcessor.class, totalOrderProcessorConsumer,
        CubicShapeRoomsProcessor.class, cubicShapeRoomsProcessorConsumer,
        DuplicatedRoomsProcessor.class, duplicatedRoomsProcessorConsumer
        );

    public void print(Processor<?> processor) {
        BiConsumer printer = processors.get(processor.getClass());
        if (null == printer) throw new RuntimeException("TODO: Create Exception");
        printer.accept(processor, roomList);
    }
}
