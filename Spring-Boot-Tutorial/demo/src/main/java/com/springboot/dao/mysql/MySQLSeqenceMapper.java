package com.springboot.dao.mysql;

import com.springboot.dao.SeqenceMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;

public interface MySQLSeqenceMapper extends SeqenceMapper {
    @Override
    @Select("select nextval('${seqName}')")
    Long getSequence(@Param("seqName") String seqName);
}