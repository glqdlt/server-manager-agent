package com.glqdlt.servermanageragent.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemoryVO {

    private String total;
    private String used;
    private String free;
    private String cached;
}
