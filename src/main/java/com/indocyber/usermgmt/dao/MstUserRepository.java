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
}
