package org.sanchez.corcoles.ana.pruebasconcepto.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.sanchez.corcoles.ana.pruebasconcepto.entity.Profile;
import org.sanchez.corcoles.ana.pruebasconcepto.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users/{userId}/profiles")
public class ProfileController {

    @Autowired
    private ProfileService service;

    @ApiOperation(value = "get profile")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "not found")
    })
    @GetMapping("/{profileId}")
    public ResponseEntity<Profile> get(@PathVariable("userId") Integer userId, @PathVariable("profileId") Integer profileId) {
        return new ResponseEntity<>(service.get(userId, profileId), HttpStatus.OK);
    }

    @ApiOperation(value = "create profile")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 404, message = "not found")
    })
    @PostMapping
    public ResponseEntity<Profile> post(@PathVariable("userId") Integer userId, @RequestBody Profile profile) {
        return new ResponseEntity<>(service.create(profile, userId), HttpStatus.CREATED);
    }
}
