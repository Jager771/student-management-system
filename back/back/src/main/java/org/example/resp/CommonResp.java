package org.example.resp;

import lombok.Data;

@Data
public class CommonResp<T> {

    private String message;
    private T content;

}
