package com.springboot.service.impl;

import com.springboot.dao.StudentDao;
import com.springboot.model.Student;
import com.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("h2StudentServiceJDBC")
public class H2StudentServiceJdbcImpl implements StudentService {
    @Autowired
    @Qualifier("h2StudentDao")
    private StudentDao studentDao;

    @Override
    public int add(Student student) {
        return this.studentDao.add(student);
    }

    @Override
    public int update(Student student) {
        return this.studentDao.update(student);
    }

    @Override
    public int deleteBysno(String sno) {
        return this.studentDao.deleteBysno(sno);
    }

    @Override
    public List<Map<String, Object>> queryStudentListMap() {
        return this.studentDao.queryStudentsListMap();
    }

    @Override
    public Student queryStudentBySno(String sno) {
        return this.studentDao.queryStudentBySno(sno);
    }

    @Override
    public Student updateWithRtn(Student student) {
        return null;
    }
}
