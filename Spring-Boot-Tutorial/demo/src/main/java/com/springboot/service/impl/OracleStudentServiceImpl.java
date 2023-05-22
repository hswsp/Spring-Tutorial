package com.springboot.service.impl;

import com.springboot.dao.StudentDao;
import com.springboot.model.Student;
import com.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service("oracleStudentServiceImpl")
public class OracleStudentServiceImpl implements StudentService {
    @Autowired
    @Qualifier("oracleStudentDaoImpl")
    private StudentDao oracleStudentDao;
    @Override
    public int add(Student student) {
        return 0;
    }

    @Override
    public int update(Student student) {
        return 0;
    }

    @Override
    public Student updateWithRtn(Student student) {
        return null;
    }

    @Override
    public int deleteBysno(String sno) {
        return 0;
    }

    @Override
    public List<Map<String, Object>> queryStudentListMap() {
        return this.oracleStudentDao.queryStudentsListMap();
    }

    @Override
    public Student queryStudentBySno(String sno) {
        return null;
    }
}
