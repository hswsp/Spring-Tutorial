package com.springboot.service.impl;

import com.springboot.dao.mysql.StudentMapper;
import com.springboot.model.Student;
import com.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("studentServiceBatis")
public class StudentServiceBatisImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public int add(Student student) {
        return this.studentMapper.add(student);
    }

    @Override
    public int update(Student student) {
        return this.studentMapper.update(student);
    }

    @Override
    public Student updateWithRtn(Student student) {
        this.studentMapper.update(student);
        return this.studentMapper.queryStudentBySno(student.getSno());
    }

    @Override
    public int deleteBysno(String sno) {
        return this.studentMapper.deleteBysno(sno);
    }

    @Override
    public Student queryStudentBySno(String sno) {
        return this.studentMapper.queryStudentBySno(sno);
    }

    @Override
    public List<Map<String, Object>> queryStudentListMap() {
        return null;
    }
}
