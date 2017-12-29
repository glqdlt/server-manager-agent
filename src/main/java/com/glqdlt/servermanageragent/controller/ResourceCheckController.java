package com.glqdlt.servermanageragent.controller;


import com.glqdlt.servermanageragent.model.DriveVO;
import com.glqdlt.servermanageragent.model.MemoryVO;
import com.glqdlt.servermanageragent.service.ResourceCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/resource")
@RestController
public class ResourceCheckController {

    @Autowired
    ResourceCheckService resourceCheckService;

    @RequestMapping(value = "/memory", method = RequestMethod.GET)
    public ResponseEntity<List<MemoryVO>> getMemory() {
        return new ResponseEntity<>(resourceCheckService.getMemoery(), HttpStatus.OK);
    }

    @RequestMapping(value = "/ip", method = RequestMethod.GET)
    public ResponseEntity<List<String>> getIp() {
        return new ResponseEntity<>(resourceCheckService.getIp(), HttpStatus.OK);
    }

    @RequestMapping(value="/disk",method = RequestMethod.GET)
    public ResponseEntity<List<DriveVO>> getDriveStorage(){
        return new ResponseEntity<>(resourceCheckService.getDrives(), HttpStatus.OK);

    }

    @RequestMapping(value="/disk/health/{target}",method = RequestMethod.GET)
    public ResponseEntity<List<String>> getDriveHealth(@PathVariable String target){
        return new ResponseEntity<List<String>>(resourceCheckService.getDriveHealth(target) ,HttpStatus.OK);
    }

}
