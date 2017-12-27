package com.glqdlt.servermanageragent.controller;


import com.glqdlt.servermanageragent.model.MemoryVO;
import com.glqdlt.servermanageragent.service.ResourceCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/resource")
@RestController
public class ResourceCheckController {

    @Autowired
    ResourceCheckService resourceCheckService;

    @RequestMapping(value = "/mem", method = RequestMethod.GET)
    public ResponseEntity<List<MemoryVO>> getMemory() {
        return new ResponseEntity<>(resourceCheckService.getMemoery(), HttpStatus.OK);
    }

}
