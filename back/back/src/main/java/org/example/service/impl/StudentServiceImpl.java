package org.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.mapper.StudentMapper;
import org.example.pojo.Student;
import org.example.req.StudentReq;
import org.example.resp.PageResp;
import org.example.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

    @Resource
    private StudentMapper studentMapper;


    @Override
    public PageResp<Student> getStudents(StudentReq studentReq) {
        LambdaQueryWrapper<Student> studentQueryWrapper = new LambdaQueryWrapper<>();
        String name = studentReq.getName();
        Integer age = studentReq.getAge();
        String gender = studentReq.getGender();

        studentQueryWrapper.like(!(name == null || "".equals(name)), Student::getName, name)
                .eq(!(age == null), Student::getAge, age)
                .eq(!(gender == null || "".equals(gender)), Student::getGender, gender);

        Page<Student> page = new Page<>(studentReq.getPage(), studentReq.getSize());
        IPage<Student> studentIPage = studentMapper.selectPage(page, studentQueryWrapper);
        PageResp<Student> pageResp = new PageResp<>();
        pageResp.setTotal(studentIPage.getTotal());
        pageResp.setList(studentIPage.getRecords());
        return pageResp;
    }

    @Override
    public void addStudents(Student student) {
        studentMapper.insert(student);
    }

    @Override
    public void removeStudent(Student student) {
        studentMapper.deleteById(student);
    }

    @Override
    public void updateStudent(Student student) {
        studentMapper.updateById(student);
    }

}
