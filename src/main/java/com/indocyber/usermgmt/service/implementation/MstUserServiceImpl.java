package com.indocyber.usermgmt.service.implementation;

import com.indocyber.usermgmt.dao.MstUserRepository;
import com.indocyber.usermgmt.dto.MstUserDTO;
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
    public MstUser getUserId(String id) {
        Optional<MstUser> theMstUser = mstUserRepository.findById(id);
        MstUser mstUser = null;
        if (theMstUser.isPresent()){
            mstUser = theMstUser.get();
        }
        return mstUser;
    }
}
