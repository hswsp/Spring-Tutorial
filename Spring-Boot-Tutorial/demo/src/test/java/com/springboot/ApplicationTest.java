package com.springboot;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.domain.OraUser;
import com.springboot.domain.User;
import com.springboot.model.Student;
import com.springboot.service.OracleUserService;
import com.springboot.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class ApplicationTest {

    @Autowired
    @Qualifier("studentServiceBatis")
    private StudentService studentService;

    @Qualifier("oracleUserServiceImpl")
    @Autowired
    private OracleUserService userService;

    @Test
    public void test() throws Exception {
        Student student1 = this.studentService.queryStudentBySno("001");
        System.out.println("学号" + student1.getSno() + "的学生姓名为：" + student1.getName());

        Student student2 = this.studentService.queryStudentBySno("001");
        System.out.println("学号" + student2.getSno() + "的学生姓名为：" + student2.getName());
    }

    @Test
    public void updateTest() throws Exception {
        Student student1 = this.studentService.queryStudentBySno("001");
        System.out.println("学号" + student1.getSno() + "的学生姓名为：" + student1.getName());

        student1.setName("康康");
        this.studentService.updateWithRtn(student1);

        Student student2 = this.studentService.queryStudentBySno("001");
        System.out.println("学号" + student2.getSno() + "的学生姓名为：" + student2.getName());
    }

    @Test
    public void mybatisPageTest(){
        //测试插入：
        OraUser user = new OraUser();
        user.setId(userService.getSequence("seq_user"));
        user.setUsername("scott");
        user.setPasswd("ac089b11709f9b9e9980e7");
        user.setCreateTime(new Date());
        user.setStatus("0");
        this.userService.save(user);

        //测试查询：
        Example example = new Example(OraUser.class);
        example.createCriteria().andCondition("username like '%i%'");
        example.setOrderByClause("id desc");
        List<OraUser> userList = this.userService.selectByExample(example);
        for (OraUser u : userList) {
            System.out.println(u.getUsername());
        }

        List<OraUser> all = this.userService.selectAll();
        for (OraUser u : all) {
            System.out.println(u.getUsername());
        }

        user = new OraUser();
        user.setId(102l);
        user = this.userService.selectByKey(user);
        System.out.println(Optional.ofNullable(user).map(OraUser::getUsername).orElse("NULL"));

        //分页测试，从第二页开始，每页2条数据：
        PageHelper.startPage(2, 2);
        List<OraUser> list = userService.selectAll();
        PageInfo<OraUser> pageInfo = new PageInfo<OraUser>(list);
        List<OraUser> result = pageInfo.getList();
        for (OraUser u : result) {
            System.out.println(u.getUsername());
        }
    }

}
