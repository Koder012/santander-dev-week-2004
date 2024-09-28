package org.santander.domain.services.implementations;

import org.santander.domain.model.User;
import org.santander.domain.repository.UserRepository;
import org.santander.domain.services.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if(userToCreate.getId() != null && userRepository.existsById(userToCreate.getId()))
            throw new IllegalArgumentException();
        return userRepository.save(userToCreate);

    }
}
