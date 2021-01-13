package com.study.jwt01.service.impl;

import com.study.jwt01.dao.AdminDOMapper;
import com.study.jwt01.model.AdminDO;
import com.study.jwt01.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    AdminDOMapper adminDOMapper;

    @Override
    public AdminDO getAdmin(AdminDO adminDO) {
        AdminDO resultAdmin=adminDOMapper.selectOne(adminDO);
        if(resultAdmin==null){
            throw new RuntimeException();
        }
        return resultAdmin;
    }
}
