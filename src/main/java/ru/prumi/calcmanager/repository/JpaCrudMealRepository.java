package ru.prumi.calcmanager.repository;

import org.springframework.stereotype.Repository;
import ru.prumi.calcmanager.model.Meal;

import java.util.Date;
import java.util.List;

@Repository
public class JpaCrudMealRepository implements MealRepository {

    private final CrudMealRepository mealRepository;
    private final CrudUserRepository userRepository;

    public JpaCrudMealRepository(CrudMealRepository mealRepository, CrudUserRepository userRepository) {
        this.mealRepository = mealRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Meal save(Meal meal, int userId) {
        if (meal.isNew() && get(meal.id(), userId) == null) {
            return null;
        }
        meal.setUser(userRepository.getOne(userId));
        return mealRepository.save(meal);
    }

    @Override
    public boolean delete(int id, int userId) {
        return mealRepository.delete(id,userId) !=0;
    }

    @Override
    public Meal get(int id, int userId) {
        return mealRepository.findById(id)
                .filter(meal -> meal.getUser().getId()==userId)
                .orElse(null);
    }

    @Override
    public List<Meal> getAll(int userId) {
        return mealRepository.getAll(userId);
    }

    @Override
    public List<Meal> getBetweenHalfOpen(Date startDate, Date endDate, int userId) {
        return mealRepository.getBetweenHalfOpen(startDate, endDate, userId);
    }

    @Override
    public Meal getWithUser(int id, int userId) {
        return mealRepository.getWithUser(id, userId);
    }
}
