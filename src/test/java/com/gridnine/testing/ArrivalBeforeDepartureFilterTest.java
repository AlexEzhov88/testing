package com.gridnine.testing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class ArrivalBeforeDepartureFilterTest {

    @Test
    @DisplayName("Тест фильтрации перелётов с некорректными датами прилёта")
    void testFilter() {
        // Arrange
        LocalDateTime departureDate1 = LocalDateTime.of(2022, 1, 1, 10, 0);
        LocalDateTime arrivalDate1 = LocalDateTime.of(2022, 1, 1, 12, 0);
        Segment segment1 = new Segment(departureDate1, arrivalDate1);
        List<Segment> segments1 = new ArrayList<>();
        segments1.add(segment1);
        Flight flight1 = new Flight(segments1);

        LocalDateTime departureDate2 = LocalDateTime.of(2022, 1, 2, 10, 0);
        LocalDateTime arrivalDate2 = LocalDateTime.of(2022, 1, 2, 8, 0);
        Segment segment2 = new Segment(departureDate2, arrivalDate2);
        List<Segment> segments2 = new ArrayList<>();
        segments2.add(segment2);
        Flight flight2 = new Flight(segments2);

        List<Flight> flights = new ArrayList<>();
        flights.add(flight1);
        flights.add(flight2);

        ArrivalBeforeDepartureFilter filter = new ArrivalBeforeDepartureFilter();

        // Act
        List<Flight> result = filter.filter(flights);

        // Assert
        assertThat(result).containsExactly(flight1);
    }
}
