package com.gridnine.testing;

/**
 * Класс для создания экземпляров фильтров
 */
class FlightFilterFactory {
    // Статический метод для создания фильтра по правилу 1
    public static FlightFilter createDepartureBeforeCurrentTimeFilter() {
        return new DepartureBeforeCurrentTimeFilter();
    }

    // Статический метод для создания фильтра по правилу 2
    public static FlightFilter createArrivalBeforeDepartureFilter() {
        return new ArrivalBeforeDepartureFilter();
    }

    // Статический метод для создания фильтра по правилу 3
    public static FlightFilter createGroundTimeExceedsFilter() {
        return new GroundTimeExceedsFilter();
    }
}
