package com.glqdlt.servermanageragent.core;

import com.glqdlt.servermanageragent.model.DriveVO;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Component
public class StorageCheckImpl implements StorageCheck {
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
    public List<DriveVO> getDriveByList(List<String> paths) {

        List<DriveVO> list = new ArrayList<>();
        String name;
        double total;
        double free;
        double avail;

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

}
