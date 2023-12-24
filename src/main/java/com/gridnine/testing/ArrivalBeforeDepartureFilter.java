package com.gridnine.testing;

import java.time.LocalDateTime;

/**
 * Подкласс для фильтрации перелётов, имеющих сегменты с датой прилёта раньше даты вылета
 */
class ArrivalBeforeDepartureFilter extends AbstractFlightFilter {
    // Конструктор, передающий предикат в суперкласс
    public ArrivalBeforeDepartureFilter() {
        super(flight -> {
            // Проверить, что для каждого сегмента перелёта дата и время прилёта не раньше даты и времени вылета
            for (Segment segment : flight.getSegments()) {
                LocalDateTime departure = segment.getDepartureDate();
                LocalDateTime arrival = segment.getArrivalDate();
                if (arrival.isBefore(departure)) {
                    return false;
                }
            }
            return true;
        });
    }
}
