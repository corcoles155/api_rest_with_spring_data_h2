package org.sanchez.corcoles.ana.pruebasconcepto.service;

import org.sanchez.corcoles.ana.pruebasconcepto.entity.User;
import org.sanchez.corcoles.ana.pruebasconcepto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> getUsers() {
        return repository.findAll();
    }
}
