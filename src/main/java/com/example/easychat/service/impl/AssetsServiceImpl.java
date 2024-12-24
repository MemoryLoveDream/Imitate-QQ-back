package com.example.easychat.service.impl;

import com.example.easychat.constants.HdfsConstant;
import com.example.easychat.data.dto.Id;
import com.example.easychat.enums.RelationshipEnum;
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

    private ResponseEntity<InputStreamResource> getFile(MediaType mediaType, String path) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(mediaType);
        return ResponseEntity.ok().headers(headers).body(new InputStreamResource(hdfsService.open(path)));
    }

    public boolean saveAvatarJpg(MultipartFile file, Integer type, String id) {
        return hdfsService.upload(file, joinAvatarJpg(type, id));
    }

    public ResponseEntity<InputStreamResource> getAvatarJpg(Integer type, String id) {
        return getFile(MediaType.IMAGE_JPEG, joinAvatarJpg(type, id));
    }

    public boolean saveChatFile(MultipartFile file, Integer type, String senderId, String receiverId,
                                String date) {
        return hdfsService.upload(file, joinChatFile(type, receiverId, senderId, date));
    }

    public ResponseEntity<InputStreamResource> getChatFile(Integer type, String senderId,
                                                           String receiverId, String date) {
        return getFile(MediaType.MULTIPART_FORM_DATA, joinChatFile(type, senderId, receiverId, date));
    }

    public boolean createIdDir(Id id) {
        if (id.getRelationType().equals(RelationshipEnum.USER.getCode())) {
            hdfsService.mkdir(HdfsConstant.USER_DIR + id);
            return hdfsService.mkdir(HdfsConstant.USER_DIR + id + HdfsConstant.CHAT_DIR);
        }
        else {
            hdfsService.mkdir(HdfsConstant.GROUP_DIR + id);
            return hdfsService.mkdir(HdfsConstant.GROUP_DIR + id + HdfsConstant.CHAT_DIR);
        }
    }

    public static String joinAvatarJpg(Integer type, String id) {
        if (type.equals(RelationshipEnum.USER.getCode())) {
            return HdfsConstant.USER_DIR + id + HdfsConstant.AVATAR_JPG;
        }
        else return HdfsConstant.GROUP_DIR + id + HdfsConstant.AVATAR_JPG;
    }

    public static String joinChatFile(Integer type, String senderId, String receiverId, String date) {
        if (type.equals(RelationshipEnum.USER.getCode())) {
            return HdfsConstant.USER_DIR + senderId + HdfsConstant.CHAT_DIR + receiverId + "/" + date;
        }
        else return HdfsConstant.GROUP_DIR + receiverId + HdfsConstant.CHAT_DIR + senderId + "/" + date;
    }

}
