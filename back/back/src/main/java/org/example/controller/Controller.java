package org.example.controller;


import com.google.gson.Gson;
import org.example.pojo.Student;
import org.example.req.StudentReq;
import org.example.resp.CommonResp;
import org.example.resp.PageResp;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@SuppressWarnings("all")
@CrossOrigin(origins = {"*", "null"})
public class Controller {
    @Autowired
    private StudentService studentService;

    private Gson gson = new Gson();

    @GetMapping("/students")
    public CommonResp getStudents(StudentReq studentReq) {
        CommonResp<PageResp<Student>> resp = new CommonResp<>();
        PageResp<Student> list = studentService.getStudents(studentReq);
        resp.setContent(list);
        return resp;
    }

    @PostMapping("/add")
    public void addStudent(@RequestBody Student student) {
        studentService.addStudents(student);
    }

    @PostMapping("/delete")
    public void removeStudent(@RequestBody Student student) {
        studentService.removeStudent(student);
    }

    @PostMapping("/update")
    public void updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
    }

    @GetMapping("/student/{number}/{name}")
    public String getstudent(@PathVariable Integer number, @PathVariable String name) {
        Student student = studentService.getStudent(number, name);
        return gson.toJson(student);
    }
}
