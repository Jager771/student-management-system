package org.example.req;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class StudentReq extends PageReq{
    private String name;
    private Integer age;
    private String gender;
}
