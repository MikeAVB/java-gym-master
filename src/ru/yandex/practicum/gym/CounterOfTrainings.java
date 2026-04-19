package ru.yandex.practicum.gym;

import java.util.Objects;

public class CounterOfTrainings implements Comparable<CounterOfTrainings> {
    private final Coach coach;
    private Integer trainingCount;

    public CounterOfTrainings(Coach coach, Integer trainingCount) {
        this.coach = coach;
        this.trainingCount = trainingCount;
    }

    public Coach getCoach() {
        return coach;
    }

    public Integer getTrainingCount() {
        return trainingCount;
    }

    public void setTrainingCount(Integer trainingCount) {
        this.trainingCount = trainingCount;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CounterOfTrainings that = (CounterOfTrainings) o;
        return Objects.equals(coach, that.coach) && Objects.equals(trainingCount, that.trainingCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coach, trainingCount);
    }

    @Override
    public int compareTo(CounterOfTrainings o) {
        return this.trainingCount - o.trainingCount;
    }

    @Override
    public String toString() {
        return String.format("Тренер: %s, кол-во тренировок: %d", coach, trainingCount);
    }
}
