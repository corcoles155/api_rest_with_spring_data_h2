package org.sanchez.corcoles.ana.pruebasconcepto.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.sanchez.corcoles.ana.pruebasconcepto.entity.Role;
import org.sanchez.corcoles.ana.pruebasconcepto.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService service;

    @ApiOperation(value = "get roles")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 404, message = "not found")
    })
    @GetMapping
    public ResponseEntity<List<Role>> getRoles() {
        return new ResponseEntity<>(service.getRoles(), HttpStatus.OK);
    }


    @ApiOperation(value = "get role by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 404, message = "not found")
    })
    @GetMapping("/{roleId}")
    public ResponseEntity<Role> get(@PathVariable("roleId") Integer roleId) {
        return new ResponseEntity<>(service.get(roleId), HttpStatus.OK);
    }


    @ApiOperation(value = "delete role")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "No content"),
            @ApiResponse(code = 404, message = "not found")
    })
    @DeleteMapping("/{roleId}")
    public ResponseEntity<Void> delete(@PathVariable("roleId") Integer roleId) {
        service.delete(roleId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "post role")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created")
    })
    @PostMapping
    public ResponseEntity<Role> post(@RequestBody Role role) {
        return new ResponseEntity<>(service.create(role), HttpStatus.CREATED);
    }

    @ApiOperation(value = "put role")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 404, message = "not found")
    })
    @PutMapping("/{roleId}")
    public ResponseEntity<Role> put(@PathVariable("roleId") Integer roleId, @RequestBody Role role) {
        return new ResponseEntity<>(service.update(roleId, role), HttpStatus.OK);
    }
}
