package ru.prumi.calcmanager.repository;

import org.springframework.data.domain.Sort;
import ru.prumi.calcmanager.model.User;

import java.util.List;

public class JpaCrudUserRepository implements UserRepository{
    private static final Sort SORT_NAME_EMAIL = Sort.by(Sort.Direction.ASC, "name", "email");

    private final CrudUserRepository userRepository;

    public JpaCrudUserRepository(CrudUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public boolean delete(int id) {
        return userRepository.delete(id) !=0;
    }

    @Override
    public User get(int id) {
        return userRepository.getOne(id);
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.getByEmail(email);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll(SORT_NAME_EMAIL);
    }

    @Override
    public User getWithMeals(int id) {
        return userRepository.getWithMeal(id);
    }
}
