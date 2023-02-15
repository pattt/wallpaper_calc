package org.wallpaper.calc;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import org.wallpaper.calc.exceptions.RoomDimensionsFormatException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

@UtilityClass
public class RoomsDimensionsParser {

    public final String DELIMITER = "x";

    @SneakyThrows
    public List<Room> parse(String path) {
        try (Stream<String> cont = Files.lines(Paths.get(path))) {
            return cont.map(line -> line.split(DELIMITER))
                .map(d -> new Room(Integer.parseInt(d[0]), Integer.parseInt(d[1]), Integer.parseInt(d[2])))
                .toList();
        } catch (IndexOutOfBoundsException e) {
            throw new RoomDimensionsFormatException(e);
        }
    }
}
