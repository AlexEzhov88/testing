package com.gridnine.testing;

import java.util.List;

/**
 * Интерфейс для фильтрации перелётов
 */
interface FlightFilter {

    /**
     * Метод для фильтрации списка перелётов
     * @param flights список перелётов
     * @return отфильтрованный список перелётов
     */
    List<Flight> filter(List<Flight> flights);
}