package com.indocyber.usermgmt.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.BitSet;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpsertMstUserDTO {
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
