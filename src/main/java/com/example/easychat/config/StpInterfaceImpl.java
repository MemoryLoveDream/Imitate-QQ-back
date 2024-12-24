//package com.example.easychat.config;
//
//import cn.dev33.satoken.stp.StpInterface;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class StpInterfaceImpl implements StpInterface {
//
//    @Override
//    public List<String> getPermissionList(Object loginId, String loginType) {
//        List<String> list = new ArrayList<String>();
//        list.add("101");
//        list.add("user.add");
//        list.add("user.update");
//        list.add("user.get");
//        // list.add("user.delete");
//        list.add("art.*");
//        return list;
//    }
//
//    @Override
//    public List<String> getRoleList(Object loginId, String loginType) {
//        List<String> list = new ArrayList<String>();
//        list.add("admin");
//        list.add("super-admin");
//        return list;
//    }
//
//}
