package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);

    List<User> listUsers();

    List<User> getUserByCarModelAndSeries(int carSeries, String model);
}