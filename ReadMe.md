# Описание модуля фильтрации авиа перелетов

Этот модуль предоставляет набор правил для фильтрации набора авиа перелетов.

## Содержание

1. [Описание проекта](#описание-проекта)
2. [Структура проекта](#структура-проекта)
3. [Требования](#требования)
4. [Установка и запуск](#установка-и-запуск)
5. [Примеры использования](#примеры-использования)
6. [Тестирование](#тестирование)


## Описание проекта

Программа фильтрует список полетов, и выдает отредактированный, который устраивает нас.

## Структура проекта

## Классы и интерфейсы

### `FlightFilter`
Интерфейс для фильтрации перелетов.

#### Методы

- `List<Flight> filter(List<Flight> flights)`: Фильтрует список перелетов 
- согласно заданным правилам.

### `AbstractFlightFilter`
Абстрактный класс с общей логикой фильтрации.

### Подклассы `DepartureBeforeCurrentTimeFilter`, `ArrivalBeforeDepartureFilter`, `GroundTimeExceedsFilter`
Подклассы, реализующие конкретные правила фильтрации.

### `FlightFilterFactory`
Фабричный класс для создания экземпляров фильтров.


## Требования

**Требования:**
- Java 11 или выше
- Maven 3.6 или выше

## Установка и запуск

**Сборка проекта:**
```bash
mvn clean install
```
Откройте командную строку (cmd) или терминал.

Перейдите в директорию, содержащую ваш JAR-файл, используя команду cd:
```bash
cd D:\working\testing\target
```

```bash
java -jar testing-1.0-SNAPSHOT.jar 
```

Запуск через Main


## Примеры использования


```java
package com.gridnine.testing;

import java.util.List;

/**
 * Интерфейс для фильтрации перелётов
 */
interface FlightFilter {

    /**
     * Метод для фильтрации списка перелётов
     * @param flights список перелётов
     * @return отфильтрованный список перелётов
     */
    List<Flight> filter(List<Flight> flights);
}
```

## Тестирование

Тесты JUnit проверяют корректность работы каждого правила фильтрации.

---
com.gridnine.testing.FlightFilterTest
- testDepartureBeforeCurrentTimeFilter
- testArrivalBeforeDepartureFilter
- testGroundTimeExceedsFilter
---
и другие ...
