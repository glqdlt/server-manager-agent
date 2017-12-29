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
import java.util.stream.Collectors;

public class TerminalHandler {

    private static final Logger log = LoggerFactory.getLogger(TerminalHandler.class);

    private TerminalHandler() {

    }

    public static TerminalHandler getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final TerminalHandler INSTANCE = new TerminalHandler();
    }

    private List<String> getConsoleOutput(String cmd[]) {

        ProcessBuilder processBuilder = new ProcessBuilder(cmd);
        processBuilder.redirectErrorStream(true);

        List<String> list = new ArrayList<>();
        try (InputStream inputStream = processBuilder.start().getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, System.getProperty("sun.jnu.encoding")));
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return list;
    }

    private List<String> blankLineToComma(List<String> list) {
        return list.stream().map(x -> x.trim().replaceAll("( )+", ",")).collect(Collectors.toList());
    }

    public List<MemoryVO> getFreeMem() {
        String[] CMD = {"free", "-h"};

        List<MemoryVO> list = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();


        blankLineToComma(getConsoleOutput(CMD)).forEach(x -> stringBuilder.append(x));

        List<String> data = Arrays.asList(stringBuilder.toString().split(","));

        list.add(new MemoryVO(data.get(6), data.get(7), data.get(8), data.get(10)));
        return list;
    }

    public List<String> getIp() {
        String QUERY = "ifconfig";
        if (System.getProperty("sun.jnu.encoding").toLowerCase().equals("MS949".toLowerCase())) {
            QUERY = "ipconfig";
        }
        String[] CMD = {QUERY};
        return getConsoleOutput(CMD);
    }

    public void doShutdown(Integer menu) {
        String[] CMD = null;
        switch (menu) {
            case 0:
                CMD = new String[]{"shutdown", "-P", "0"};
                break;
            case 1:
                CMD = new String[]{"shutdown", "-r", "0"};
                break;
            default:
                CMD = new String[]{" "};
        }
        getConsoleOutput(CMD);
    }

    public List<String> getDriveHealth(String target){
        String[] CMD = {"smartctl","--all",target};
        return getConsoleOutput(CMD);
    }
}
