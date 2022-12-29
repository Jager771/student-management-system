package org.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.gson.Gson;
import org.example.mapper.StudentMapper;
import org.example.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@SuppressWarnings("all")
@CrossOrigin(origins = {"*", "null"})
public class Controller {
    @Autowired
    private StudentMapper studentMapper;
    private Gson gson = new Gson();

    @GetMapping("/students")
    public String getStudents() {
        List<Student> students = studentMapper.selectList(null);
        return gson.toJson(students);
    }

    @PostMapping("/add")
    public void addStudent(@RequestBody Student student) {
        studentMapper.insert(student);
    }

    @PostMapping("/delete")
    public void removeStudent(@RequestBody Student student) {
        studentMapper.deleteById(student);
    }

    @PostMapping("/update")
    public void updateStudent(@RequestBody Student student) {
        studentMapper.updateById(student);
    }

    @PostMapping("/search")
    public String search(@RequestBody HashMap<String, String> data) {
        String name = data.get("name");
        QueryWrapper<Student> studentQueryWrapper = new QueryWrapper<>();
        studentQueryWrapper.like("name", name);
        List<Student> students = studentMapper.selectList(studentQueryWrapper);
        return gson.toJson(students);
    }

}
