package com.indocyber.usermgmt.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MstUserDTO {
    private String id;
    private String userFullname;
    private Boolean flagActive;
    private String email;
    private String passwd;
    private Instant createdDate;
    private String createdBy;
    private Instant updatedDate;
    private String updatedBy;
}
