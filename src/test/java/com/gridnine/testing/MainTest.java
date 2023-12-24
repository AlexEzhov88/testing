package com.gridnine.testing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Тестирование класса Main")
class MainTest {

    @Test
    @DisplayName("main не должен выбрасывать исключение")
    void main_shouldNotThrowException() {
        assertDoesNotThrow(() -> Main.main(new String[]{}));
    }

    @Test
    @DisplayName("printFlights должен выводить перелеты в консоль без исключений")
    void printFlights_shouldPrintFlights() {
        List<Flight> flights = FlightBuilder.createFlights();
        assertNotNull(flights);

        assertDoesNotThrow(() -> Main.printFlights(flights));
    }

    @Test
    @DisplayName("printFlights должен корректно обрабатывать null в качестве входного списка")
    void printFlights_shouldHandleNullList() {
        assertDoesNotThrow(() -> Main.printFlights(null));
    }

    @Test
    @DisplayName("перелеты должны быть успешно выведены в консоль")
    void main_shouldPrintFlightsSuccessfully() {
        List<Flight> flights = FlightBuilder.createFlights();
        assertNotNull(flights);

        assertThatCode(() -> Main.main(new String[]{})).doesNotThrowAnyException();
    }
}
