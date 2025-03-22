package me.dio.santander_dev_week_2023_dio.service;

import me.dio.santander_dev_week_2023_dio.domain.model.User;

public interface UserService {
    User findById(Long id);
    User create(User user);
}
