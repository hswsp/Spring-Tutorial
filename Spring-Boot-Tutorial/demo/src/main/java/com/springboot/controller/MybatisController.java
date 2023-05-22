package com.springboot.controller;

import com.springboot.model.Student;
import com.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class MybatisController {
    @Autowired
    @Qualifier("studentServiceBatis")
    private StudentService studentService;

    @RequestMapping(value = "/querystudentB", method = RequestMethod.GET)
    public Student queryStudentBySno(String sno) {
        return this.studentService.queryStudentBySno(sno);
    }

    @RequestMapping(value = "/queryallstudentB")
    public List<Map<String, Object>> queryAllStudent() {
        return this.studentService.queryStudentListMap();
    }

    @RequestMapping(value = "/addstudentB", method = RequestMethod.GET)
    public int saveStudent(String sno,String name,String sex) {
        Student student = new Student();
        student.setSno(sno);
        student.setName(name);
        student.setSex(sex);
        return this.studentService.add(student);
    }

    @RequestMapping(value = "deletestudentB", method = RequestMethod.GET)
    public int deleteStudentBySno(String sno) {
        return this.studentService.deleteBysno(sno);
    }
}
