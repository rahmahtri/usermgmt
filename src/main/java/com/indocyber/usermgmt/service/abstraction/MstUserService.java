package com.indocyber.usermgmt.service.abstraction;

import com.indocyber.usermgmt.dto.MstUserDTO;
import com.indocyber.usermgmt.entity.MstUser;

public interface MstUserService {
    public MstUser addUser(MstUserDTO dto);
}
