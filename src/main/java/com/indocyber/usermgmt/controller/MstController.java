package com.indocyber.usermgmt.controller;

import com.indocyber.usermgmt.service.abstraction.MstUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/usermgmt/v1/user")
public class MstController {

    @Autowired
    private MstUserService service;

    @GetMapping(value = "/list")
    public ResponseEntity<Object> get(
            @RequestParam(defaultValue = "") String id,
            @RequestParam(defaultValue = "") String name,
            @RequestParam(defaultValue = "") String email,
            @RequestParam(defaultValue = "1") Integer page
    ){
        try {
            var pageObject = service.getGrid(id,name,email,page);
            return ResponseEntity.status(HttpStatus.OK).body(pageObject);
        } catch (Exception exception){
            return ResponseEntity.status(500).body(exception.getMessage());
        }
    }
}
