package org.example.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
//@TableName("draft_test_student_management_system")
public class Student {
    private Integer id;
    private Integer number;
    private String name;
    private Integer age;
    private String gender;
}
