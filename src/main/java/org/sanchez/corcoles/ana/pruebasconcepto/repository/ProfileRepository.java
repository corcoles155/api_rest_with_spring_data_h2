package org.sanchez.corcoles.ana.pruebasconcepto.repository;

import org.sanchez.corcoles.ana.pruebasconcepto.entity.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Integer> {

}
