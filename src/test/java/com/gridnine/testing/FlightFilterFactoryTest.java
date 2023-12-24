package com.gridnine.testing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Тесты для FlightFilterFactory")
class FlightFilterFactoryTest {

    @Test
    @DisplayName("Тест создания фильтра DepartureBeforeCurrentTimeFilter")
    void testCreateDepartureBeforeCurrentTimeFilter() {
        FlightFilter filter = FlightFilterFactory.createDepartureBeforeCurrentTimeFilter();
        assertThat(filter).isNotNull();
    }

    @Test
    @DisplayName("Тест создания фильтра ArrivalBeforeDepartureFilter")
    void testCreateArrivalBeforeDepartureFilter() {
        FlightFilter filter = FlightFilterFactory.createArrivalBeforeDepartureFilter();
        assertThat(filter).isNotNull();
    }

    @Test
    @DisplayName("Тест создания фильтра GroundTimeExceedsFilter")
    void testCreateGroundTimeExceedsFilter() {
        FlightFilter filter = FlightFilterFactory.createGroundTimeExceedsFilter();
        assertThat(filter).isNotNull();
    }
}