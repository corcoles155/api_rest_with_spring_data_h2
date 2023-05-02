package org.sanchez.corcoles.ana.pruebasconcepto.service;

import org.sanchez.corcoles.ana.pruebasconcepto.entity.Address;
import org.sanchez.corcoles.ana.pruebasconcepto.entity.Profile;
import org.sanchez.corcoles.ana.pruebasconcepto.repository.AddressRepository;
import org.sanchez.corcoles.ana.pruebasconcepto.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ProfileRepository profileRepository;

    public List<Address> get(final Integer userId, final Integer profileId) {
        return addressRepository.findByProfileAndUserId(userId, profileId);
    }

    public Address create(final Integer userId, final Integer profileId, final Address address) {
        final Optional<Profile> profile = profileRepository.findByUserIdAndProfileId(userId, profileId);
        if (profile.isPresent()) {
            address.setProfile(profile.get());
            return addressRepository.save(address);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Profile with id %d and user with id %d doesn't exist", profileId, userId));
    }
}
