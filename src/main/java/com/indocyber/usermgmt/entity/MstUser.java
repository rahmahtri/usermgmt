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
    private Boolean flagActive = false;

    @Column(name = "email", length = 200)
    private String email;

    @Column(name = "passwd", nullable = false, length = 100)
    private String passwd;

    @Column(name = "created_date")
    private Instant createdDate;

    @Column(name = "created_by", length = 10)
    private String createdBy;

    @Column(name = "updated_date")
    private Instant updatedDate;

    @Column(name = "updated_by", length = 10)
    private String updatedBy;
}