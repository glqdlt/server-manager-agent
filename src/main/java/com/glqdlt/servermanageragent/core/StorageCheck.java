package com.glqdlt.servermanageragent.core;

import com.glqdlt.servermanageragent.model.DriveVO;

import java.util.List;

public interface StorageCheck {
    public List<DriveVO> getDrives();
    public List<DriveVO> getDriveByPath(String path);
    public List<DriveVO> getDriveByList(List<String> paths);
}
