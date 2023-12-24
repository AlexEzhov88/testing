package com.gridnine.testing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Тесты для класса FlightBuilder")
class FlightBuilderTest {

    @Test
    @DisplayName("Тест метода createFlight")
    void testCreateFlight() {
        // Создаем даты вылета и прилета для двух сегментов
        LocalDateTime departure1 = LocalDateTime.now();
        LocalDateTime arrival1 = departure1.plusHours(2);
        LocalDateTime departure2 = arrival1.plusHours(1);
        LocalDateTime arrival2 = departure2.plusHours(2);

        // Создаем перелет на основе переданных дат
        Flight flight = FlightBuilder.createFlight(departure1, arrival1, departure2, arrival2);

        // Проверяем, что созданный перелет не является null
        assertThat(flight).isNotNull();

        // Проверяем, что количество сегментов в перелете равно ожидаемому
        assertThat(flight.getSegments()).hasSize(2);

        // Добавляем дополнительные проверки для каждого сегмента в перелете
        for (Segment segment : flight.getSegments()) {
            // Проверяем, что каждый сегмент в перелете имеет корректные даты вылета и прилета
            assertThat(segment.getDepartureDate()).isNotNull();
            assertThat(segment.getArrivalDate()).isNotNull();
            assertThat(segment.getDepartureDate()).isBefore(segment.getArrivalDate());
        }
    }
}
