package org.sanchez.corcoles.ana.pruebasconcepto.service;

import org.sanchez.corcoles.ana.pruebasconcepto.entity.Role;
import org.sanchez.corcoles.ana.pruebasconcepto.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    private RoleRepository repository;

    public List<Role> getRoles() {
        return repository.findAll();
    }

    public Role create(final Role role) {
        return repository.save(role);
    }

    public Role update(Integer roleId, Role role) {
        final Optional<Role> result = repository.findById(roleId);
        if (result.isPresent()) {
            return repository.save(role);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Role with id %d doesn't exist", roleId));
    }

    public Role get(Integer roleId) {
        final Optional<Role> result = repository.findById(roleId);
        if (result.isPresent()) {
            return result.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Role with id %d doesn't exist", roleId));
    }

    public void delete(Integer roleId) {
        final Role result = get(roleId);
        repository.delete(result);
    }
}
