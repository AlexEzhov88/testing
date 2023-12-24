package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Абстрактный класс с общей логикой фильтрации
 */
abstract class AbstractFlightFilter implements FlightFilter {
    // Предикат, определяющий условие фильтрации для каждого перелёта
    protected Predicate<Flight> predicate;

    // Защищённый конструктор, принимающий предикат
    protected AbstractFlightFilter(Predicate<Flight> predicate) {
        this.predicate = predicate;
    }

    // Реализация метода filter, применяющая предикат к каждому перелёту
    @Override
    public List<Flight> filter(List<Flight> flights) {
        List<Flight> result = new ArrayList<>();
        for (Flight flight : flights) {
            if (predicate.test(flight)) {
                result.add(flight);
            }
        }
        return result;
    }
}
