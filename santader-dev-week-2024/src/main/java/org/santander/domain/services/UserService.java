package org.santander.domain.services;

import org.santander.domain.model.User;

public interface UserService {

    User findById(Long id);
    User create(User userToCreate);
}
