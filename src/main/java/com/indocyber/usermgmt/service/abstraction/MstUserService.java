package com.indocyber.usermgmt.service.abstraction;

public interface MstUserService {
    public MstUser addUser(MstUserDTO dto);
    String saveMstUser(UpsertMstUserDTO dto);

    MstUser getUserId(String id);

    void getDeleteUser(String id);

}
