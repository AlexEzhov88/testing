package com.gridnine.testing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Тесты для GroundTimeExceedsFilter")
class GroundTimeExceedsFilterTest {

    @Test
    @DisplayName("Тест фильтрации перелётов с превышением времени на земле")
    public void testFilter() {
        // Создаем перелеты с разным временем на земле
        Segment segment1 = new Segment(LocalDateTime.now(), LocalDateTime.now().plusHours(1));
        Segment segment2 = new Segment(LocalDateTime.now().plusHours(2), LocalDateTime.now().plusHours(3));
        Segment segment3 = new Segment(LocalDateTime.now().plusHours(4), LocalDateTime.now().plusHours(5));

        List<Segment> segments1 = Arrays.asList(segment1, segment2, segment3);
        List<Segment> segments2 = Arrays.asList(segment1, segment2);
        List<Segment> segments3 = Arrays.asList(segment1, segment3);

        Flight flight1 = new Flight(segments1);
        Flight flight2 = new Flight(segments2);
        Flight flight3 = new Flight(segments3);

        // Создаем фильтр
        GroundTimeExceedsFilter filter = new GroundTimeExceedsFilter();

        // Фильтруем перелеты
        List<Flight> filteredFlights = filter.filter(Arrays.asList(flight1, flight2, flight3));

        // Проверяем, что ожидаемый результат соответствует фактическому
        assertThat(filteredFlights).hasSize(2);
        assertThat(filteredFlights).containsExactlyInAnyOrder(flight2, flight1);
    }
}
