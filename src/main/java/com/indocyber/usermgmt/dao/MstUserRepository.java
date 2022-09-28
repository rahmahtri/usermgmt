package com.indocyber.usermgmt.dao;

import com.indocyber.usermgmt.entity.MstUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface MstUserRepository extends JpaRepository<MstUser, String> {

//    @Query("""
//            SELECT COUNT(*)
//            FROM MstUser AS user
//            WHERE user.id = :userId
//            """)
//    public Long count(@Param("userId") String userId);

    @Query(nativeQuery = true, value = """
            SELECT us.user_id
            FROM mst_user AS us
            ORDER BY us.user_id DESC
            LIMIT 1
            """)
    public String descId();
import com.indocyber.usermgmt.dto.MstUserDTO;
import com.indocyber.usermgmt.entity.MstUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MstUserRepository extends JpaRepository<MstUser, Long> {
    @Query("""
            SELECT new com.indocyber.usermgmt.dto.MstUserDTO(
            mu.id,
            mu.userFullname,
            mu.flagActive,
            mu.email,
            mu.passwd,
            mu.createdDate,
            mu.createdBy,
            mu.updatedDate,
            mu.updatedBy
            )
            FROM MstUser As mu
            WHERE mu.flagActive = TRUE
            AND mu.id LIKE %:id%
            AND mu.userFullname LIKE %:userFullname%
            AND mu.id LIKE %:email%
            
            """)
    public Page<MstUserDTO> findAllActive(
            @Param("id") String id,
            @Param("userFullname") String userFullname,
            @Param("email") String email,
            Pageable pageable);

}
