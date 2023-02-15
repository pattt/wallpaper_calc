package org.wallpaper.calc;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Collections;
import java.util.List;

@ToString
@EqualsAndHashCode
public class Room {

    private final RoomDimensions roomDimensions;

    @Getter
    private final String name;
    private final Integer wallASquare;
    private final Integer wallBSquare;
    private final Integer ceilingSquare;

    public Room(Integer length, Integer width, Integer height) {
        wallASquare = width * height;
        wallBSquare = length * height;
        ceilingSquare = length * width;
        roomDimensions = new RoomDimensions(length, width, height);
        name = String.format("%dx%dx%d", length, width, height);
    }

    public Integer getSquare() {
        return 2 * wallASquare + 2 * wallBSquare + 2 * ceilingSquare;
    }

    public Integer getAdditionalSquare() {
        return Collections.min(List.of(wallASquare, wallBSquare, ceilingSquare));
    }

    public Integer getRequiredSquare() {
        return getSquare() + getAdditionalSquare();
    }

    public Boolean isCubic() {
        return roomDimensions.length().equals(roomDimensions.width())
            && roomDimensions.width().equals(roomDimensions.height());
    }
}
