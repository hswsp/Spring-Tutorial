package com.springboot.service;

import com.springboot.model.Student;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;
import java.util.Map;
@CacheConfig(cacheNames = "student")
public interface StudentService {
    int add(Student student);

    int update(Student student);

    @CachePut(key = "#p0.sno")
    Student updateWithRtn(Student student);

    @CacheEvict(key = "#p0", allEntries = true)
    int deleteBysno(String sno);

    List<Map<String, Object>> queryStudentListMap();

    @Cacheable(key = "#p0")
    Student queryStudentBySno(String sno);
}
