package com.glqdlt.servermanageragent.controller;

import com.glqdlt.servermanageragent.service.ResourceCheckService;
import com.glqdlt.servermanageragent.utill.TerminalHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/power")
@RestController
public class PowerController {

    @Autowired
    ResourceCheckService resourceCheckService;

    @RequestMapping("/{query}")
    public ResponseEntity<?> shutdown(@PathVariable String query) {
        int menu = 0;
        if (query.toLowerCase().equals("shutdown".toLowerCase())) {

        } else if (query.toLowerCase().equals("restart".toLowerCase())) {
            menu = 1;
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        TerminalHandler.getInstance().doShutdown(menu);
        return new ResponseEntity(HttpStatus.OK);
    }

}
