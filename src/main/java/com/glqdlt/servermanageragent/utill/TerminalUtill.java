package com.glqdlt.servermanageragent.utill;


import com.glqdlt.servermanageragent.model.MemoryVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TerminalUtill {

    private static final Logger log = LoggerFactory.getLogger(TerminalUtill.class);

    private TerminalUtill() {

    }

    public static TerminalUtill getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final TerminalUtill INSTANCE = new TerminalUtill();
    }

    private String getConsoleOutput(String cmd[]) {

        ProcessBuilder processBuilder = new ProcessBuilder(cmd);
        processBuilder.redirectErrorStream(true);

        StringBuilder stringBuilder = new StringBuilder();
        try (InputStream inputStream = processBuilder.start().getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return stringBuilder.toString().trim().replaceAll("( )+", ",");
    }

    public List<MemoryVO> getMemoery() {
        String[] cmd = {"free", "-h"};
        List<MemoryVO> list = new ArrayList<>();
        List<String> data = Arrays.asList(getConsoleOutput(cmd).split(","));
        list.add(new MemoryVO(data.get(6), data.get(7), data.get(8), data.get(10)));
        return list;
    }
}
