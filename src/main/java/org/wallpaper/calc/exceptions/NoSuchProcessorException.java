package org.wallpaper.calc.exceptions;

import lombok.Getter;

public class NoSuchProcessorException extends RuntimeException {
    @Getter
    private final String processorClass;

    public NoSuchProcessorException(String processorClass) {
        this.processorClass = processorClass;
    }
}
