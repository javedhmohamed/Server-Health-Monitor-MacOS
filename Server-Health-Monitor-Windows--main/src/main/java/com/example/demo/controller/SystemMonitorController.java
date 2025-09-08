package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@RestController
@RequestMapping("/api/monitor")
public class SystemMonitorController {

    @GetMapping("/cpu")
    public String getCpuUsage() throws IOException, InterruptedException {
        return runScript("scripts/cpu.sh");
    }

    @GetMapping("/memory")
    public String getMemoryUsage() throws IOException, InterruptedException {
        return runScript("scripts/memory.sh");
    }

    @GetMapping("/disk")
    public String getDiskUsage() throws IOException, InterruptedException {
        return runScript("scripts/disk.sh");
    }

    private String runScript(String scriptPath) throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder("bash", scriptPath);
        pb.redirectErrorStream(true);
        Process process = pb.start();

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder output = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            output.append(line).append("\n");
        }

        process.waitFor();
        return output.toString();
    }
}