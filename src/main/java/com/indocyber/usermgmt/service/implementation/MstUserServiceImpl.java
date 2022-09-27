package com.indocyber.usermgmt.service.implementation;

import com.indocyber.usermgmt.dao.MstUserRepository;
import com.indocyber.usermgmt.dto.UpsertMstUserDTO;
import com.indocyber.usermgmt.entity.MstUser;
import com.indocyber.usermgmt.service.abstraction.MstUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MstUserServiceImpl implements MstUserService {

    @Autowired
    private MstUserRepository mstUserRepository;

    @Override
    public String saveMstUser(UpsertMstUserDTO dto) {
        MstUser entity = new MstUser(
                dto.getId(),
                dto.getUserFullname(),
                dto.getFlagActive(),
                dto.getEmail(),
                dto.getPasswd(),
                dto.getCreatedDate(),
                dto.getCreatedBy(),
                dto.getUpdatedDate(),
                dto.getUpdatedBy()
                );
        MstUser respond = mstUserRepository.save(entity);
        return respond.getId();
    }
}

