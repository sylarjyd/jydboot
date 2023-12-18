package com.jyd.config.minio;

import lombok.Data;

@Data
public class ObjectItemVo {
    private String objectName;
    private Long size;
}
