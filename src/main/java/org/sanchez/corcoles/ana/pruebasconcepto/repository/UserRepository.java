package org.sanchez.corcoles.ana.pruebasconcepto.repository;

import org.sanchez.corcoles.ana.pruebasconcepto.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
