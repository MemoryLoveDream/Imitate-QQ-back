package com.example.easychat.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import java.io.IOException;

@Slf4j
@org.springframework.context.annotation.Configuration
public class HadoopConfig {

    @Value("${hdfs.defaultFS}")
    private String hdfsPath;

    @Bean
    public FileSystem fileSystem() {
        FileSystem fileSystem = null;
        Configuration configuration = new Configuration();
        configuration.set("fs.defaultFS", hdfsPath);
        try {
            fileSystem = FileSystem.get(configuration);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return fileSystem;
    }
}