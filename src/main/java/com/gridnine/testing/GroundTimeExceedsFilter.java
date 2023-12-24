package com.gridnine.testing;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Подкласс для фильтрации перелётов, у которых общее время, проведённое на земле, превышает два часа
 */
class GroundTimeExceedsFilter extends AbstractFlightFilter {
    // Константа для максимального времени на земле в секундах
    private static final long MAX_GROUND_TIME = 2 * 60 * 60;

    // Конструктор, передающий предикат в суперкласс
    public GroundTimeExceedsFilter() {
        super(flight -> {
            // Проверить, что сумма интервалов между прилётом одного сегмента и вылетом следующего за ним не превышает два часа
            List<Segment> segments = flight.getSegments();
            long groundTime = 0;
            for (int i = 0; i < segments.size() - 1; i++) {
                LocalDateTime arrival = segments.get(i).getArrivalDate();
                LocalDateTime departure = segments.get(i + 1).getDepartureDate();
                groundTime += Duration.between(arrival, departure).getSeconds();
                if (groundTime > MAX_GROUND_TIME) {
                    return false;
                }
            }
            return true;
        });
    }
}
