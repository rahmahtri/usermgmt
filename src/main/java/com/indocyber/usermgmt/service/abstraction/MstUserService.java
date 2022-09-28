package com.indocyber.usermgmt.service.abstraction;

import com.indocyber.usermgmt.dto.MstUserDTO;
import com.indocyber.usermgmt.entity.MstUser;
import org.springframework.data.domain.Page;


public interface MstUserService {

    public Page<MstUserDTO> getGrid(
            String id,
            String name,
            String email,
            Integer page);
}
