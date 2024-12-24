package com.example.easychat.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Slf4j
@Service
public class HdfsService {

    @Autowired
    private FileSystem fileSystem;


    public boolean upload(MultipartFile file, String path) {
        try {
            try (FSDataOutputStream outputStream = fileSystem.create(new Path(path));
                 InputStream inputStream = file.getInputStream()) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
            }
            return true;
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return false;
    }

    public boolean upload(String src, String dst) {
        try {
            fileSystem.copyFromLocalFile(new Path(src), new Path(dst));
            return true;
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return false;
    }

    public boolean delete(String file) {
        try {
            fileSystem.delete(new Path(file), true);
            return true;
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return false;
    }

    public boolean mkdir(String file) {
        try {
            return fileSystem.mkdirs(new Path(file));
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return false;
    }

    public FSDataInputStream open(String hdfsPath) {
        try {
            return fileSystem.open(new Path(hdfsPath));
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return null;
    }

    public byte[] readFile(String hdfsPath) {
        try {
            return fileSystem.open(new Path(hdfsPath)).readAllBytes();
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return null;
    }

}