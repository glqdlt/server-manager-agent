package com.glqdlt.servermanageragent.service;

import com.glqdlt.servermanageragent.core.StorageCheck;
import com.glqdlt.servermanageragent.model.DriveVO;
import com.glqdlt.servermanageragent.model.MemoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceCheckService {

    @Autowired
    StorageCheck storageCheck;

    public List<String> getDriveHealth(String target){
        return storageCheck.getDriveHealth(target);
    }

    public List<DriveVO> getDrives() {

        return storageCheck.getDriveStatic();
    }

    public List<DriveVO> getDriveByPath(String path) {
        return storageCheck.getDriveByPath(path);
    }

    public List<MemoryVO> getMemoery() {
        return storageCheck.getMemory();
    }

    public List<String> getIp() {return storageCheck.getIp();}


}
