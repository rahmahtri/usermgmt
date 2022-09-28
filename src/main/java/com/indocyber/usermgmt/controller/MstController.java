package com.indocyber.usermgmt.controller;

import com.indocyber.usermgmt.dto.MstUserDTO;
import com.indocyber.usermgmt.dto.UpsertMstUserDTO;
import com.indocyber.usermgmt.entity.MstUser;
import com.indocyber.usermgmt.service.abstraction.MstUserService;
import com.indocyber.usermgmt.service.implementation.MstUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    @Autowired
    private MstUserService mstUserService;

    @PutMapping("/update")
    public ResponseEntity<Object> update(@Valid @RequestBody UpsertMstUserDTO dto, BindingResult bindingResult){
        try {
            if(!bindingResult.hasErrors()){
                mstUserService.saveMstUser(dto);
                return ResponseEntity.status(HttpStatus.OK).body(dto);
            } else {
                return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Validation Failed, Http Request Body is not validated.");
            }
        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("There is a run-time error on the server.");
        }
    }


    @GetMapping("/{id}")
    private ResponseEntity<Object> findUserById(@PathVariable String id){

        if(mstUserService.getUserId(id)==null){
            String message = String.format("Data user dengan ID : %s tidak ditemukan",id);
            return new  ResponseEntity<>(message,HttpStatus.NOT_FOUND);
        } else {
            MstUser theUser = mstUserService.getUserId(id);
            return new ResponseEntity<>(theUser,HttpStatus.OK);
        }
    }

    @PutMapping("/delete/{id}")
    private ResponseEntity<Object> deleteUser (@PathVariable String id){

        if(mstUserService.getUserId(id)==null){
            String message = String.format("Data user dengan ID : %s tidak ditemukan",id);
            return new  ResponseEntity<>(message,HttpStatus.NOT_FOUND);
        } else {
            mstUserService.getDeleteUser(id);
            String message = String.format("Data user dengan ID : %s berhasil di delete",id);
            return new ResponseEntity<>(message,HttpStatus.OK);
            }
      }

    @GetMapping(value = "/list")
    public ResponseEntity<Object> get(
            @RequestParam(defaultValue = "") String id,
            @RequestParam(defaultValue = "") String userFullname,
            @RequestParam(defaultValue = "") String email,
            @RequestParam(defaultValue = "1") Integer page
    ){
        try {
            var pageObject = service.getGrid(id,userFullname,email,page);
            return ResponseEntity.status(HttpStatus.OK).body(pageObject);
        } catch (Exception exception){
            return ResponseEntity.status(500).body(exception.getMessage());
        }
    }

}
