package org.example.resp;

import lombok.Data;

import java.util.List;

@Data
public class PageResp<T> {
    private long total;
    private List<T> list;

}
