package edu.kata.task311.service.impl;

import edu.kata.task311.entity.User;
import edu.kata.task311.repository.UserRepository;
import edu.kata.task311.service.UserService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("User is not found by id " + id)
        );

    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        userRepository.save(user);
        return user;
    }

//    @Override
//    public User update(Long id) {
//        User user = userRepository.findUserById(id);
//
//        return null;
//    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);

    }
}
