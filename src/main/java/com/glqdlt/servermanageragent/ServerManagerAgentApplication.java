package com.glqdlt.servermanageragent;

import com.glqdlt.servermanageragent.service.DriveInformationService;
import com.glqdlt.servermanageragent.service.ResourceCheckService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.glqdlt.servermanageragent.*")
@SpringBootApplication
public class ServerManagerAgentApplication implements CommandLineRunner {

    private static Logger logger = LoggerFactory.getLogger(CommandLineRunner.class);

    @Autowired
    ResourceCheckService storageCheckService;

    @Autowired
    DriveInformationService driveInformationService;

    public static void main(String[] args) {
        SpringApplication.run(ServerManagerAgentApplication.class, args);
    }

    @Override
    public void run(String... strings) {

    }
}
