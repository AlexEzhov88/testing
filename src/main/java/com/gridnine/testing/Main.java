package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс для проверочного запуска
 */
public class Main {
    /**
     * Основной метод программы
     *
     * @param args Аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        try {
            List<Flight> flights = FlightBuilder.createFlights();

            if (!flights.isEmpty()) {
                System.out.println("Исходный список перелётов:");
                printFlights(flights);

                System.out.println("Список перелётов по правилу 1 (вылет до текущего момента времени):");
                FlightFilter filter1 = FlightFilterFactory.createDepartureBeforeCurrentTimeFilter();
                printFilteredFlights(filter1, flights);

                System.out.println("Список перелётов по правилу 2 (имеются сегменты с датой прилёта раньше даты вылета):");
                FlightFilter filter2 = FlightFilterFactory.createArrivalBeforeDepartureFilter();
                printFilteredFlights(filter2, flights);

                System.out.println("Список перелётов по правилу 3 (общее время, проведённое на земле превышает два часа):");
                FlightFilter filter3 = FlightFilterFactory.createGroundTimeExceedsFilter();
                printFilteredFlights(filter3, flights);

                // Вывести отфильтрованные перелёты
                System.out.println("Отфильтрованные перелёты после всех фильтров :");
                List<Flight> filteredFlights = filter1.filter(flights);
                filteredFlights.retainAll(filter2.filter(flights));
                filteredFlights.retainAll(filter3.filter(flights));
                printFlights(filteredFlights);
            } else {
                System.out.println("Список перелётов пуст или равен null.");
                // Дополнительная обработка, если необходимо
            }
        } catch (Exception e) {
            // Обработка исключений, если необходимо
            e.printStackTrace();
        }
    }

    /**
     * Вспомогательный метод для вывода списка перелётов
     *
     * @param flights Список перелётов для вывода
     */
    static void printFlights(List<Flight> flights) {
        if (flights != null && !flights.isEmpty()) {
            for (Flight flight : flights) {
                System.out.println(flight);
            }
        } else {
            System.out.println("Список перелётов пуст или равен null.");
        }
        System.out.println();
    }

    /**
     * Вспомогательный метод для вывода списка отфильтрованных перелётов и убранных из списка
     *
     * @param filter  Фильтр, применяемый к перелётам
     * @param flights Исходный список перелётов
     */
    static void printFilteredFlights(FlightFilter filter, List<Flight> flights) {
        List<Flight> filteredFlights = filter.filter(flights);
        List<Flight> removedFlights = new ArrayList<>(flights);
        removedFlights.removeAll(filteredFlights);

        if (!removedFlights.isEmpty()) {
            System.out.println("Убрано из списка:");
            for (Flight flight : removedFlights) {
                System.out.println(flight);
            }
            System.out.println();
        }

        System.out.println("Отфильтрованные перелёты:");
        printFlights(filteredFlights);
    }
}
