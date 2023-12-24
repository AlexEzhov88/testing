package com.gridnine.testing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class DepartureBeforeCurrentTimeFilterTest {

    @Test
    @DisplayName("Тест фильтрации перелётов с некорректными датами вылета")
    void testFilter() {
        // Arrange
        LocalDateTime currentDateTime = LocalDateTime.now();

        LocalDateTime departureDate1 = currentDateTime.plusHours(1);
        LocalDateTime arrivalDate1 = currentDateTime.plusHours(2);
        Segment segment1 = new Segment(departureDate1, arrivalDate1);
        List<Segment> segments1 = new ArrayList<>();
        segments1.add(segment1);
        Flight flight1 = new Flight(segments1);

        LocalDateTime departureDate2 = currentDateTime.minusHours(1); // Исправлено здесь
        LocalDateTime arrivalDate2 = currentDateTime.plusHours(2);
        Segment segment2 = new Segment(departureDate2, arrivalDate2);
        List<Segment> segments2 = new ArrayList<>();
        segments2.add(segment2);
        Flight flight2 = new Flight(segments2);

        List<Flight> flights = new ArrayList<>();
        flights.add(flight1);
        flights.add(flight2);

        DepartureBeforeCurrentTimeFilter filter = new DepartureBeforeCurrentTimeFilter();

        // Act
        List<Flight> result = filter.filter(flights);

        // Assert
        assertThat(result).containsExactly(flight1);

    }
}