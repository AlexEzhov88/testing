package com.gridnine.testing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("FlightFilter тесты")
class FlightFilterTest {

    @Test
    @DisplayName("Фильтр: вылет до текущего момента времени")
    void testDepartureBeforeCurrentTimeFilter() {
        List<Flight> flights = FlightBuilder.createFlights();
        FlightFilter filter = FlightFilterFactory.createDepartureBeforeCurrentTimeFilter();
        List<Flight> result = filter.filter(flights);
        assertThat(result).hasSize(5);
    }

    @Test
    @DisplayName("Фильтр: сегменты с датой прилёта раньше даты вылета")
    void testArrivalBeforeDepartureFilter() {
        List<Flight> flights = FlightBuilder.createFlights();
        FlightFilter filter = FlightFilterFactory.createArrivalBeforeDepartureFilter();
        List<Flight> result = filter.filter(flights);
        assertThat(result).hasSize(5);
    }

    @Test
    @DisplayName("Фильтр: общее время, проведённое на земле превышает два часа")
    void testGroundTimeExceedsFilter() {
        List<Flight> flights = FlightBuilder.createFlights();
        FlightFilter filter = FlightFilterFactory.createGroundTimeExceedsFilter();
        List<Flight> result = filter.filter(flights);
        assertThat(result).hasSize(4);
    }

    @Test
    @DisplayName("Обработка ошибок: пустой перелёт")
    void testEmptyFlight() {
        FlightFilter filter = FlightFilterFactory.createDepartureBeforeCurrentTimeFilter();
        List<Flight> result = filter.filter(List.of());
        assertThat(result).isEmpty();
    }

    @Test
    @DisplayName("Фильтр: перелёт с одним сегментом")
    void testSingleSegmentFlight() {
        // Создаем перелёт с одним сегментом
        Flight singleSegmentFlight = new Flight(List.of(new Segment(LocalDateTime.now(), LocalDateTime.now().plusHours(2))));

        // Применяем фильтр
        FlightFilter filter = FlightFilterFactory.createDepartureBeforeCurrentTimeFilter();
        List<Flight> result = filter.filter(List.of(singleSegmentFlight));

        // Проверяем, что в результате должен быть пустой список, так как вылет в будущем
        assertThat(result).isEmpty();
    }

}
