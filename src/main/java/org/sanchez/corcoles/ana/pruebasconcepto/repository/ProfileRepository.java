package org.sanchez.corcoles.ana.pruebasconcepto.repository;

import org.sanchez.corcoles.ana.pruebasconcepto.entity.Profile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Integer> {

    @Query("SELECT p FROM Profile p WHERE p.user.id=?1 and p.id=?2")
    Optional<Profile> findByUserIdAndProfileId(Integer userId, Integer profileId);
}
