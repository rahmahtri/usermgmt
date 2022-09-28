package com.indocyber.usermgmt.service.implementation;

import com.indocyber.usermgmt.dao.MstUserRepository;
import com.indocyber.usermgmt.dto.MstUserDTO;
import com.indocyber.usermgmt.dto.UpsertMstUserDTO;
import com.indocyber.usermgmt.entity.MstUser;
import com.indocyber.usermgmt.service.abstraction.MstUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Optional;


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

    @Override
    public MstUser getUserId(String id) {
        Optional<MstUser> theMstUser = mstUserRepository.findById(id);
        MstUser mstUser = null;
        if (theMstUser.isPresent()){
            mstUser = theMstUser.get();
        }
        return mstUser;
    }

    @Override
    public void getDeleteUser(String id) {
        Optional<MstUser> theMstUser = mstUserRepository.findById(id);
        MstUser mstUser = theMstUser.get();

        mstUser.setFlagActive(false);
        mstUserRepository.save(mstUser);
    }
}
