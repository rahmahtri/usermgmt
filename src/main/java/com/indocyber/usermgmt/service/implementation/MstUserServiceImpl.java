package com.indocyber.usermgmt.service.implementation;

import com.indocyber.usermgmt.dao.MstUserRepository;
import com.indocyber.usermgmt.dto.MstUserDTO;
import com.indocyber.usermgmt.entity.MstUser;
import com.indocyber.usermgmt.service.abstraction.MstUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class MstUserServiceImpl implements MstUserService {

    @Autowired
    private MstUserRepository mstUserRepository;

    private final Integer rowInPage = 10;

    @Override
    public Page<MstUserDTO> getGrid(
            String id,
            String name,
            String email,
            Integer page) {
        var pagination = PageRequest.of(page - 1, rowInPage, Sort.by("id"));
        var pageObject = mstUserRepository.findAllActive(
                id,
                name,
                email,
                pagination);
        return pageObject;
    }
}
