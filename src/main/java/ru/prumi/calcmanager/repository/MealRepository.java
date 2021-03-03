package ru.prumi.calcmanager.repository;

import ru.prumi.calcmanager.model.Meal;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface MealRepository {
    Meal save(Meal meal, int userId);

    boolean delete(int id, int userId);

    Meal get(int id, int userId);

    List<Meal> getAll(int userId);

    List<Meal> getBetweenHalfOpen(Date startDate, Date endDate, int userId);

    default Meal getWithUser(int id, int userId){throw new UnsupportedOperationException();}
}
