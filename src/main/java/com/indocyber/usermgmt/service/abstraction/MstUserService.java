package com.indocyber.usermgmt.service.abstraction;

import com.indocyber.usermgmt.dto.MstUserDTO;
import com.indocyber.usermgmt.entity.MstUser;
import com.indocyber.usermgmt.dto.UpsertMstUserDTO;

public interface MstUserService {
    String saveMstUser(UpsertMstUserDTO dto);
    
    MstUser getUserId(String id);

    void getDeleteUser(String id);

}
