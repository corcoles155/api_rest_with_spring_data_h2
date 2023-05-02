package org.sanchez.corcoles.ana.pruebasconcepto.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.sanchez.corcoles.ana.pruebasconcepto.entity.Address;
import org.sanchez.corcoles.ana.pruebasconcepto.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/{userId}/profiles/{profileId}/addresses")
public class AddressController {

    @Autowired
    private AddressService service;

    @ApiOperation(value = "get addresses")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "not found")
    })
    @GetMapping()
    public ResponseEntity<List<Address>> get(@PathVariable("userId") Integer userId,
                                             @PathVariable("profileId") Integer profileId) {
        return new ResponseEntity<>(service.get(userId, profileId), HttpStatus.OK);
    }

    @ApiOperation(value = "create address")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 404, message = "not found")
    })
    @PostMapping
    public ResponseEntity<Address> post(@PathVariable("userId") Integer userId,
                                        @PathVariable("profileId") Integer profileId,
                                        @RequestBody Address address) {
        return new ResponseEntity<>(service.create(userId, profileId, address), HttpStatus.CREATED);
    }
}
