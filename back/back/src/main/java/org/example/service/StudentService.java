package org.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.pojo.Student;
import org.example.req.StudentReq;
import org.example.resp.PageResp;

public interface StudentService extends IService<Student> {
    PageResp<Student> getStudents(StudentReq studentReq);

    void addStudents(Student student);

    void removeStudent(Student student);

    void updateStudent(Student student);

    Student getStudent(Integer number, String name);
}
