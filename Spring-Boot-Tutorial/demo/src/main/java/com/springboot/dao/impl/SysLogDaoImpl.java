package com.springboot.dao.impl;

import com.springboot.dao.SysLogDao;
import com.springboot.domain.SysLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SysLogDaoImpl implements SysLogDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void saveSysLog(SysLog syslog) {
        String sql_seq = "SELECT nextval('seq_sys_log')";
        Integer seq = this.jdbcTemplate.queryForList(sql_seq,Integer.class).get(0);

        StringBuffer sql = new StringBuffer("insert into sys_log ");
        sql.append("(id,username,operation,time,method,params,ip,create_time) ");
        sql.append("values(:seq,:username,:operation,:time,:method,");
        sql.append(":params,:ip,:createTime)");
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("seq", seq);
        map.addValue("username", syslog.getUsername());
        map.addValue("operation", syslog.getOperation());
        map.addValue("time", syslog.getTime());
        map.addValue("method", syslog.getMethod());
        map.addValue("params", syslog.getParams());
        map.addValue("ip", syslog.getIp());
        map.addValue("createTime", syslog.getCreateTime());
        NamedParameterJdbcTemplate npjt = new NamedParameterJdbcTemplate(this.jdbcTemplate.getDataSource());
        npjt.update(sql.toString(), map);
    }
}
