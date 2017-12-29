package com.glqdlt.servermanageragent.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/heartbeat")
public class HeartBeatController {

    @RequestMapping("/ping")
    public ResponseEntity<?> echo() {

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
