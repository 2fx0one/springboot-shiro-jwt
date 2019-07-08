package com.tfx0one.modules.sys.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Map;

@Data
@Accessors(chain = true)
public class ResponseSysMenu {

    private Long id;
    private String name;
    private String component;
    private String path;

    private Map<String, Object> meta;

    private List<ResponseSysMenu> children;


//    public static ResponseSysMenu create(SysMenuEntity e) {
//
//        ResponseSysMenu self = new ResponseSysMenu();
//        self.setId(e.getMenuId());
//        self.setComponent(e.getUrl());
//        self.setName(e.getName());
//        if (e.getUrl() != null) {
//            String pathName = e.getUrl().replace("/", "-");
//            return self
//                    .setPath(pathName)
//                    .setComponent(e.getUrl())
//                    .setName(pathName)
//                    .setMeta(MapUtils.create().put("menuId", e.getMenuId()).put("title", e.getName()).put("iframeUrl", ""))
//                    ;
//        } else {
//            return self;
//        }
//    }
//
//    public static ResponseSysMenu bulild(ResponseSysMenu t) {
//        if (t.getUrl() != null) {
//            String pathName = t.getUrl().replace("/", "-");
//            t.setPath(pathName)
//                    .setName(pathName);
//
//        }
//        return t;
//    }
}
