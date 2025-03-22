package me.dio.santander_dev_week_2023_dio.service.implementation;

import me.dio.santander_dev_week_2023_dio.domain.model.User;
import me.dio.santander_dev_week_2023_dio.domain.repository.UserRepository;
import me.dio.santander_dev_week_2023_dio.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
public class UserServiceImplementation implements UserService {
    private final UserRepository repository;
    public UserServiceImplementation(UserRepository repository) {
        this.repository = repository;
    }
    @Override
    public User findById(Long id) {
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    @Transactional
    public User create(User user) {
        return repository.save(user);
    }
}
