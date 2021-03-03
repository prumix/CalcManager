package ru.prumi.calcmanager.repository;

import ru.prumi.calcmanager.model.User;

import java.util.List;

public interface UserRepository {
    User save(User user);

    boolean delete(int id);

    User get(int id);

    User getByEmail(String email);

    List<User> getAll();

    default User getWithMeals(int id){throw new UnsupportedOperationException();}
}
