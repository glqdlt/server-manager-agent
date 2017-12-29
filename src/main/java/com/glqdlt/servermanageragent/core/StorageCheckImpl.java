package com.glqdlt.servermanageragent.core;

import com.glqdlt.servermanageragent.model.DriveVO;
import com.glqdlt.servermanageragent.model.MemoryVO;
import com.glqdlt.servermanageragent.utill.TerminalHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class StorageCheckImpl implements StorageCheck {

    private static final Logger log = LoggerFactory.getLogger(StorageCheckImpl.class);

    @Override
    public List<DriveVO> getDrives() {

        File[] roots = File.listRoots();
        String name;
        double total;
        double avail;
        double free;

        List<DriveVO> list = new ArrayList<>();

        for (File root : roots) {
            name = root.getAbsolutePath();
            total = root.getTotalSpace() / Math.pow(1024, 3);
            avail = root.getUsableSpace() / Math.pow(1024, 3);
            free = total - avail;
            list.add(new DriveVO(total, free, avail, name));
        }
        return list;
    }

    @Override
    public List<String> getIp() {
        return TerminalHandler.getInstance().getIp();
    }

    @Override
    public List<DriveVO> getDriveByPath(String path) {

        File file = new File(path);
        String name;
        double total;
        double avail;
        double free;

        List<DriveVO> list = new ArrayList<>();

        name = file.getAbsolutePath();
        total = file.getTotalSpace() / Math.pow(1024, 3);
        avail = file.getUsableSpace() / Math.pow(1024, 3);
        free = total - avail;
        list.add(new DriveVO(total, free, avail, name));
        return list;
    }

    @Override
    public List<String> getDriveHealth(String target) {
        return TerminalHandler.getInstance().getDriveHealth(target);
    }

    @Override
    public List<DriveVO> getDriveStatic() {

        List<DriveVO> list = new ArrayList<>();
        String name;
        double total;
        double free;
        double avail;


        List<String> paths =Arrays.asList("/home/glqdlt/archive/sda","/home/glqdlt/archive/sdb","/");



        for (String path : paths) {
            File file = new File(path);
            name = file.getAbsolutePath();
            total = file.getTotalSpace() / Math.pow(1024, 3);
            free = file.getUsableSpace() / Math.pow(1024, 3);
            avail = total - free;
            list.add(new DriveVO(total, free, avail, name));
        }

        return list;
    }

    @Override
    public List<MemoryVO> getMemory() {
        return TerminalHandler.getInstance().getFreeMem();
    }
}
