package com.gridnine.testing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.assertj.core.api.Assertions.assertThat;

class SegmentTest {

    @Test
    @DisplayName("Тест метода getDepartureDate")
    void testGetDepartureDate() {
        // Arrange
        LocalDateTime departureDate = LocalDateTime.of(2022, 1, 1, 10, 0);
        LocalDateTime arrivalDate = LocalDateTime.of(2022, 1, 1, 12, 0);
        Segment segment = new Segment(departureDate, arrivalDate);

        // Act
        LocalDateTime result = segment.getDepartureDate();

        // Assert
        assertThat(result).isEqualTo(departureDate);
    }

    @Test
    @DisplayName("Тест метода getArrivalDate")
    void testGetArrivalDate() {
        // Arrange
        LocalDateTime departureDate = LocalDateTime.of(2022, 1, 1, 10, 0);
        LocalDateTime arrivalDate = LocalDateTime.of(2022, 1, 1, 12, 0);
        Segment segment = new Segment(departureDate, arrivalDate);

        // Act
        LocalDateTime result = segment.getArrivalDate();

        // Assert
        assertThat(result).isEqualTo(arrivalDate);
    }

    @Test
    @DisplayName("Тест метода toString")
    void testToString() {
        // Arrange
        LocalDateTime departureDate = LocalDateTime.of(2022, 1, 1, 10, 0);
        LocalDateTime arrivalDate = LocalDateTime.of(2022, 1, 1, 12, 0);
        Segment segment = new Segment(departureDate, arrivalDate);

        // Act
        String result = segment.toString();

        // Assert
        assertThat(result).isEqualTo("[2022-01-01T10:00|2022-01-01T12:00]");
    }
}
