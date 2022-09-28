package com.indocyber.usermgmt.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MstUserDTO {
    private String id;
    private String userFullname;
    private Boolean flagActive = false;
    private String email;
    private String passwd;
    private LocalDateTime createdDate = LocalDateTime.now();
    private String createdBy = "SYSTEM";
    private LocalDateTime updatedDate;
    private String updatedBy;

    public MstUserDTO(String id, String userFullname, Boolean flagActive, String email, String passwd) {
        this.id = id;
        this.userFullname = userFullname;
        this.flagActive = flagActive;
        this.email = email;
        this.passwd = passwd;
    }

    public MstUserDTO(String id, String userFullname, Boolean flagActive, String email, String passwd, LocalDateTime createdDate, String createdBy) {
        this.id = id;
        this.userFullname = userFullname;
        this.flagActive = flagActive;
        this.email = email;
        this.passwd = passwd;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
    }
}
