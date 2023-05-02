package org.sanchez.corcoles.ana.pruebasconcepto.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.sanchez.corcoles.ana.pruebasconcepto.entity.User;
import org.sanchez.corcoles.ana.pruebasconcepto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @ApiOperation(value = "get users")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 404, message = "not found")
    })
    @GetMapping
    public ResponseEntity<Page<User>> getUsers(@RequestParam(name = "page", required = false, defaultValue = "0") int page,
                                               @RequestParam(name = "size", required = false, defaultValue = "20") int size) {
        return new ResponseEntity<>(service.getUsers(page, size), HttpStatus.OK);
    }

    @ApiOperation(value = "get usernames")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 404, message = "not found")
    })
    @GetMapping("/usernames")
    public ResponseEntity<List<String>> getUsernames() {
        return new ResponseEntity<>(service.getUsernames(), HttpStatus.OK);
    }

    @ApiOperation(value = "get user by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 404, message = "not found")
    })
    @GetMapping("/{userId}")
    public ResponseEntity<User> get(@PathVariable("userId") Integer userId) {
        return new ResponseEntity<>(service.get(userId), HttpStatus.OK);
    }

    @ApiOperation(value = "get user by username")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 404, message = "not found")
    })
    @GetMapping("/username/{username}")
    public ResponseEntity<User> get(@PathVariable("username") String username) {
        return new ResponseEntity<>(service.getByUsername(username), HttpStatus.OK);
    }


    @ApiOperation(value = "delete user")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "No content"),
            @ApiResponse(code = 404, message = "not found")
    })
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> delete(@PathVariable("userId") Integer userId) {
        service.delete(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @ApiOperation(value = "create user")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created")
    })
    @PostMapping
    public ResponseEntity<User> post(@RequestBody User user) {
        return new ResponseEntity<>(service.create(user), HttpStatus.CREATED);
    }


    @ApiOperation(value = "put user")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 404, message = "not found")
    })
    @PutMapping("/{userId}")
    public ResponseEntity<User> put(@PathVariable("userId") Integer userId, @RequestBody User user) {
        return new ResponseEntity<>(service.update(userId, user), HttpStatus.OK);
    }
}
