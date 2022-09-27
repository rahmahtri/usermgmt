package com.indocyber.usermgmt.service.abstraction;

import com.indocyber.usermgmt.dto.UpsertMstUserDTO;

public interface MstUserService {
    String saveMstUser(UpsertMstUserDTO dto);
}
