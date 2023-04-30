package org.sanchez.corcoles.ana.pruebasconcepto.service;

import org.sanchez.corcoles.ana.pruebasconcepto.entity.User;
import org.sanchez.corcoles.ana.pruebasconcepto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public Page<User> getUsers(int page, int size) {
        return repository.findAll(PageRequest.of(page, size));
    }

    public User create(final User user) {
        return repository.save(user);
    }

    public User update(Integer userId, User user) {
        final Optional<User> result = repository.findById(userId);
        if (result.isPresent()) {
            return repository.save(user);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User with id %d doesn't exist", userId));
    }

    public User get(Integer userId) {
        return repository.findById(userId).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User with id %d doesn't exist", userId)));
    }

    public User getByUsername(String username) {
        return repository.findByUsername(username).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User with username %s doesn't exist", username)));
    }

    public void delete(Integer userId) {
        final User result = get(userId);
        repository.delete(result);
    }

    public List<String> getUsernames() {
        return repository.findUsernames();
    }
}
