package com.springboot.dao.impl;

import com.springboot.dao.StudentDao;
import com.springboot.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("oracleStudentDaoImpl")
public class OracleStudentDaoImpl implements StudentDao {

    @Autowired
    @Qualifier("oracleJdbcTemplate")
    private JdbcTemplate jdbcTemplate;
    @Override
    public int add(Student student) {
        return 0;
    }

    @Override
    public int update(Student student) {
        return 0;
    }

    @Override
    public int deleteBysno(String sno) {
        return 0;
    }

    @Override
    public List<Map<String, Object>> queryStudentsListMap() {
        return this.jdbcTemplate.queryForList("select * from student");
    }

    @Override
    public Student queryStudentBySno(String sno) {
        return null;
    }
}
