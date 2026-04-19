package ru.yandex.practicum.gym;

public enum DayOfWeek {
    MONDAY("Понедельник"),
    TUESDAY("Вторник"),
    WEDNESDAY("Среда"),
    THURSDAY("Четверг"),
    FRIDAY("Пятница"),
    SATURDAY("Суббота"),
    SUNDAY("Воскресенье");

    private final String name;

    DayOfWeek(String day) {
        this.name = day;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
