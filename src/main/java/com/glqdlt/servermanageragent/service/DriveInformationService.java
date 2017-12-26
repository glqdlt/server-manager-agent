package com.glqdlt.servermanageragent.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DriveInformationService {

    public List<String> getInformtions() {
        List<String> list = new ArrayList<>();
        list.add("/home/glqdlt/archive/sda");
        list.add("/home/glqdlt/archive/sdb");
        list.add("/");
        return list;
    }
}
