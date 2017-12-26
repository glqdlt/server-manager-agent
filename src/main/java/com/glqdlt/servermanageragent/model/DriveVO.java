package com.glqdlt.servermanageragent.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class DriveVO {

    private double total;
    private double free;
    private double avail;
    private String name;

}
