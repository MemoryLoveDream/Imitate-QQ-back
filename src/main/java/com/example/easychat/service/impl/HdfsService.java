package com.example.easychat.service.impl;

import com.example.easychat.enums.RelationshipEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@Slf4j
@Service
public class HdfsService {

    public static final String USER_DIR = "/social/users/";

    public static final String GROUP_DIR = "/social/groups/";

    public static final String Avatar_JPG = "/avatar.jpg";

    @Autowired
    private FileSystem fileSystem;

    public boolean upload(MultipartFile file, String path) {
        String fileName = file.getOriginalFilename();
        BufferedOutputStream out;
        try {
            if (fileName != null) {
                out = new BufferedOutputStream(new FileOutputStream(fileName));
                out.write(file.getBytes());
                out.flush();
                out.close();
                fileSystem.copyFromLocalFile(new Path(fileName), new Path(path));
                return true;
            }
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

    public static String joinAvatarJpg(Integer type, String id) {
        if (type.equals(RelationshipEnum.USER.getCode())) {
            return USER_DIR + id + Avatar_JPG;
        }
        else return GROUP_DIR + id + Avatar_JPG;
    }

}