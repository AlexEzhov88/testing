package com.gridnine.testing;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс, представляющий перелёт.
 */
class Flight {
    private final List<Segment> segments;

    Flight(final List<Segment> segs) {
        segments = segs;
    }

    /**
     * Возвращает список сегментов перелёта.
     *
     * @return список сегментов перелёта
     */
    List<Segment> getSegments() {
        return segments;
    }

    @Override
    public String toString() {
        return segments.stream().map(Object::toString)
                .collect(Collectors.joining(" "));
    }
}
