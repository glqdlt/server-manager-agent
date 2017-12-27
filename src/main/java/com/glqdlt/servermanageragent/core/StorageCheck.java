package com.glqdlt.servermanageragent.core;

import com.glqdlt.servermanageragent.model.DriveVO;
import com.glqdlt.servermanageragent.model.MemoryVO;

import java.util.List;

public interface StorageCheck {

    List<DriveVO> getDrives();

    List<DriveVO> getDriveByPath(String path);

    List<DriveVO> getDriveByList(List<String> paths);

    List<MemoryVO> getMemory();

}
