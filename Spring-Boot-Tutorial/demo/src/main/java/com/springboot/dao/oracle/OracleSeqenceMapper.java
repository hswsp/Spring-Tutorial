package com.springboot.dao.oracle;

import com.springboot.dao.SeqenceMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface OracleSeqenceMapper extends SeqenceMapper {
    @Override
    @Select("select ${seqName}.nextval from dual")
    Long getSequence(@Param("seqName") String seqName);
}
