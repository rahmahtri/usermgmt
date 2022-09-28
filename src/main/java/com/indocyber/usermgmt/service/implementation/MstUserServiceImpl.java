package com.indocyber.usermgmt.service.implementation;

import com.indocyber.usermgmt.dao.MstUserRepository;
import com.indocyber.usermgmt.dto.MstUserDTO;
import com.indocyber.usermgmt.entity.MstUser;
import com.indocyber.usermgmt.service.abstraction.MstUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;


@Service
public class MstUserServiceImpl implements MstUserService {

    @Autowired
    MstUserRepository mstUserRepository;

    @Override
    public MstUser addUser(MstUserDTO dto) {
        String id = dto.getId();
        var lastId = mstUserRepository.descId();
        Long formatId = Long.parseLong(lastId);
        var sumId = formatId + 1;
        id = String.format(Locale.getDefault(), "%03d", sumId);

        var addUser = new MstUser(
                id.toString(),
                dto.getUserFullname(),
                dto.getFlagActive(),
                dto.getEmail(),
                dto.getPasswd(),
                dto.getCreatedDate(),
                dto.getCreatedBy()
        );
        var response = mstUserRepository.save(addUser);
        return response;
    }
}
