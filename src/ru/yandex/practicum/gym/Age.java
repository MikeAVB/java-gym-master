package ru.yandex.practicum.gym;

public enum Age {
    CHILD("Детский"), ADULT("Взрослый");

    private final String description;

    Age(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }
}
