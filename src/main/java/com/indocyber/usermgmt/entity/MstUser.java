package com.indocyber.usermgmt.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mst_user")
public class MstUser {
    @Id
    @Column(name = "user_id", nullable = false, length = 10)
    private String id;

    @Column(name = "user_fullname", nullable = false, length = 200)
    private String userFullname;

    @Column(name = "flag_active", nullable = false)
    private Boolean flagActive = true;

    @Column(name = "email", length = 200)
    private String email;

    @Column(name = "passwd", nullable = false, length = 100)
    private String passwd;

    @Column(name = "created_date")
    private LocalDateTime createdDate = LocalDateTime.now();

    @Column(name = "created_by", length = 10)
    private String createdBy = "SYSTEM";

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @Column(name = "updated_by", length = 10)
    private String updatedBy;

    public MstUser(String id, String userFullname, Boolean flagActive, String email, String passwd) {
        this.id = id;
        this.userFullname = userFullname;
        this.flagActive = flagActive;
        this.email = email;
        this.passwd = passwd;
    }

    public MstUser(String id, String userFullname, Boolean flagActive, String email, String passwd, LocalDateTime createdDate, String createdBy) {
        this.id = id;
        this.userFullname = userFullname;
        this.flagActive = flagActive;
        this.email = email;
        this.passwd = passwd;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
    }
}