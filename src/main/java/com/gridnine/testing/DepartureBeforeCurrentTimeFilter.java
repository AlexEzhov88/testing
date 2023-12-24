package com.gridnine.testing;

import java.time.LocalDateTime;

/**
 * Подкласс для фильтрации перелётов, вылетающих до текущего момента времени
 */
class DepartureBeforeCurrentTimeFilter extends AbstractFlightFilter {
    // Конструктор, передающий предикат в суперкласс
    public DepartureBeforeCurrentTimeFilter() {
        super(flight -> {
            if (flight.getSegments().isEmpty()) {
                // Обработка случая, когда у перелёта нет сегментов
                return false;
            }
            // Получить дату и время вылета первого сегмента перелёта
            LocalDateTime departure = flight.getSegments().get(0).getDepartureDate();
            // Проверить, что она не раньше текущего момента времени
            return departure.isAfter(LocalDateTime.now());
        });
    }
}

