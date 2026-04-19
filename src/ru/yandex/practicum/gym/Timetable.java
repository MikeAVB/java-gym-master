package ru.yandex.practicum.gym;

import java.util.*;

public class Timetable {

    private final HashMap<DayOfWeek, TreeMap<TimeOfDay, ArrayList<TrainingSession>>> timetable;

    public Timetable() {
        timetable = new HashMap<>();
        timetable.put(DayOfWeek.MONDAY, new TreeMap<>());
        timetable.put(DayOfWeek.TUESDAY, new TreeMap<>());
        timetable.put(DayOfWeek.WEDNESDAY, new TreeMap<>());
        timetable.put(DayOfWeek.THURSDAY, new TreeMap<>());
        timetable.put(DayOfWeek.FRIDAY, new TreeMap<>());
        timetable.put(DayOfWeek.SATURDAY, new TreeMap<>());
        timetable.put(DayOfWeek.SUNDAY, new TreeMap<>());
    }

    public void addNewTrainingSession(TrainingSession trainingSession) {
        //сохраняем занятие в расписании
        TreeMap<TimeOfDay, ArrayList<TrainingSession>> daySchedule = timetable.get(trainingSession.getDayOfWeek());
        if (daySchedule.containsKey(trainingSession.getTimeOfDay())) {
            ArrayList<TrainingSession> sessions = daySchedule.get(trainingSession.getTimeOfDay());
            sessions.add(trainingSession);
        } else {
            daySchedule.put(trainingSession.getTimeOfDay(), new ArrayList<>(List.of(trainingSession)));
        }
    }

    public TreeMap<TimeOfDay, ArrayList<TrainingSession>> getTrainingSessionsForDay(DayOfWeek dayOfWeek) {
        //как реализовать, тоже непонятно, но сложность должна быть О(1)
        return timetable.get(dayOfWeek);
    }

    public ArrayList<TrainingSession> getTrainingSessionsForDayAndTime(DayOfWeek dayOfWeek, TimeOfDay timeOfDay) {
        //как реализовать, тоже непонятно, но сложность должна быть О(1)
        TreeMap<TimeOfDay, ArrayList<TrainingSession>> daySchedule = timetable.get(dayOfWeek);
        if (daySchedule.containsKey(timeOfDay)) {
            return daySchedule.get(timeOfDay);
        } else {
            return new ArrayList<>();
        }
    }

    public List<CounterOfTrainings> getCountByCoaches() {
        HashMap<Coach, CounterOfTrainings> trainingsHashMap = new HashMap<>();
        for (TreeMap<TimeOfDay, ArrayList<TrainingSession>> schedules : timetable.values()) {
            for (ArrayList<TrainingSession> sessions : schedules.values()) {
                for (TrainingSession session : sessions) {
                    if (trainingsHashMap.containsKey(session.getCoach())) {
                        CounterOfTrainings counter = trainingsHashMap.get(session.getCoach());
                        counter.setTrainingCount(counter.getTrainingCount() + 1);
                    } else {
                        trainingsHashMap.put(session.getCoach(), new CounterOfTrainings(session.getCoach(), 1));
                    }
                }
            }
        }
        ArrayList<CounterOfTrainings> counterOfTrainings = new ArrayList<>(trainingsHashMap.values());
        counterOfTrainings.sort(Comparator.reverseOrder());
        return counterOfTrainings;
    }
}
