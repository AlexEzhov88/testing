package com.gridnine.testing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class FlightTest {

    @Test
    @DisplayName("Тест метода getSegments()")
    void testGetSegments() {
        // Создаем список сегментов
        Segment segment1 = new Segment(LocalDateTime.now(), LocalDateTime.now().plusHours(2));
        Segment segment2 = new Segment(LocalDateTime.now().plusHours(3), LocalDateTime.now().plusHours(5));
        List<Segment> segments = Arrays.asList(segment1, segment2);

        // Создаем объект перелета с сегментами
        Flight flight = new Flight(segments);

        // Проверяем метод getSegments()
        assertThat(flight.getSegments()).isEqualTo(segments);
    }

    @Test
    @DisplayName("Тест метода toString()")
    void testToString() {
        // Создаем список сегментов
        Segment segment1 = new Segment(LocalDateTime.now(), LocalDateTime.now().plusHours(2));
        Segment segment2 = new Segment(LocalDateTime.now().plusHours(3), LocalDateTime.now().plusHours(5));
        List<Segment> segments = Arrays.asList(segment1, segment2);

        // Создаем объект перелета с сегментами
        Flight flight = new Flight(segments);

        // Проверяем метод toString()
        String expected = segment1 + " " + segment2;
        assertThat(flight.toString()).isEqualTo(expected);
    }
}