package org.sanchez.corcoles.ana.pruebasconcepto.service;

import org.sanchez.corcoles.ana.pruebasconcepto.entity.Profile;
import org.sanchez.corcoles.ana.pruebasconcepto.entity.User;
import org.sanchez.corcoles.ana.pruebasconcepto.repository.ProfileRepository;
import org.sanchez.corcoles.ana.pruebasconcepto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private UserRepository userRepository;


    public Profile create(final Profile profile, final Integer userId) {
        final Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            profile.setUser(user.get());
            return profileRepository.save(profile);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User with id %d doesn't exist", userId));
    }

    public Profile get(Integer userId, Integer profileId) {
        return profileRepository.findByUserIdAndProfileId(userId, profileId).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Profile with id %d doesn't exist for user with id %d", profileId, userId)));
    }
}
