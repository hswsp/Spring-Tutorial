package com.springboot.service.impl;

import com.springboot.domain.OraUser;
import com.springboot.dao.oracle.OracleSeqenceMapper;
import com.springboot.service.OracleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("oracleUserServiceImpl")
public class OracleUserServiceImpl extends BaseService<OraUser> implements OracleUserService {
    @Autowired
    public void setSeqenceMapper(OracleSeqenceMapper seqenceMapper) {
        this.seqenceMapper = seqenceMapper;
    }
}
