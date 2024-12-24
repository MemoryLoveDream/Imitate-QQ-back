package com.example.easychat.service.impl;

import com.example.easychat.data.dto.Id;
import com.example.easychat.enums.RelationshipEnum;
import org.apache.hadoop.fs.FSDataInputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AssetsServiceImpl {

    @Autowired
    private HdfsService hdfsService;

    public boolean uploadHeadJpg(MultipartFile file, Integer type, String id) {
        if (type.equals(RelationshipEnum.USER.getCode())) {
            return hdfsService.upload(file, HdfsService.USER_DIR + id);
        }
        else return hdfsService.upload(file, HdfsService.GROUP_DIR + id);
    }

    public boolean createIdDir(Id id) {
        if (id.getType().equals(RelationshipEnum.USER.getCode())) {
            return hdfsService.mkdir(HdfsService.USER_DIR + id);
        }
        else return hdfsService.mkdir(HdfsService.GROUP_DIR + id);
    }

    public ResponseEntity<InputStreamResource> getAvatarJpg(Integer type, String id) {
        FSDataInputStream inputStream = hdfsService.open(HdfsService.joinAvatarJpg(type, id));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return ResponseEntity.ok().headers(headers).body(new InputStreamResource(inputStream));
    }

}
