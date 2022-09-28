package com.indocyber.usermgmt.controller;

import com.indocyber.usermgmt.dto.MstUserDTO;
import com.indocyber.usermgmt.service.implementation.MstUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Controller
@RequestMapping("/usermgmt/v1/user")
public class MstController {

    @Autowired
    MstUserServiceImpl service;

    @PostMapping("/add")
    public ResponseEntity<Object> addUser(@RequestBody MstUserDTO dto){
        try{
            var response = service.addUser(dto);
            return ResponseEntity.status(200).body(response);
        }catch (Exception exception) {
            return ResponseEntity.status(500).body(exception.getMessage());
        }

    }
}
