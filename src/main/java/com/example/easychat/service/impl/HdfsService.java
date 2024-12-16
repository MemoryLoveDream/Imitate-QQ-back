package com.example.easychat.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Slf4j
@Service
public class HdfsService {

    @Autowired
    private FileSystem fileSystem;

    public void uploadFile(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        BufferedOutputStream out;
        try {
            if (fileName != null) {
                out = new BufferedOutputStream(new FileOutputStream(fileName));
                out.write(file.getBytes());
                out.flush();
                out.close();
                fileSystem.copyFromLocalFile(new Path(fileName), new Path("/social/users/"+fileName));
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    public void delete(String file) {
        try {
            fileSystem.delete(new Path(file), true);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
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