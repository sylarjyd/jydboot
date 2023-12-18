package com.jyd.config.minio;

import cn.hutool.core.util.IdUtil;
import com.jyd.common.constant.CommonConstants;
import com.jyd.entity.OssFile;
import com.jyd.service.IFileService;
import io.minio.*;
import io.minio.messages.DeleteError;
import io.minio.messages.DeleteObject;
import io.minio.messages.Item;
import org.apache.commons.compress.utils.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MinioUtil {

    @Autowired
    private MinioClientConfig minioClientConfig;

    @Autowired
    private MinioClient minioClient;

    @Autowired
    private IFileService fileService;

    /**
     * 判断bucket是否存在，不存在则创建
     **/
    public void existBucket(String name) {
        try {
            boolean exists = minioClient.bucketExists(BucketExistsArgs.builder().bucket(name).build());
            if (!exists) {
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(name).build());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建存储bucket
     **/
    public Boolean makeBucket(String name) {
        try {
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(name).build());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 删除存储bucket
     */
    public Boolean removeBucket(String name) {
        try {
            minioClient.removeBucket(RemoveBucketArgs.builder()
                    .bucket(name)
                    .build());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<OssFile> upload(MultipartFile file) {
        return upload(Arrays.asList(file));
    }

    /**
     * 批量上传文件
     **/
    public List<OssFile> upload(List<MultipartFile> multipartFile) {
        List<OssFile> fileSaveList = new ArrayList<>(multipartFile.size());
        for (MultipartFile file : multipartFile) {
            String originalFilename = file.getOriginalFilename();
            String fileName = LocalDateTime.now().format(DateTimeFormatter.ofPattern(CommonConstants.DATE_PATTERN_YMD)) + "/" + IdUtil.simpleUUID();
            if (originalFilename.contains(".")) {
                fileName += originalFilename.substring(originalFilename.lastIndexOf("."));
            }
            InputStream in = null;
            try {
                in = file.getInputStream();
                minioClient.putObject(PutObjectArgs.builder()
                        .bucket(minioClientConfig.getBucketName())
                        .object(fileName)
                        .stream(in, in.available(), -1)
                        .contentType(file.getContentType())
                        .build()
                );
                OssFile ossFile = new OssFile();
                ossFile.setId(IdUtil.simpleUUID());
                ossFile.setOriginalName(originalFilename);
                ossFile.setCreateTime(LocalDateTime.now());
                ossFile.setDeleted(CommonConstants.ZERO);
                ossFile.setStatus(CommonConstants.ZERO);
                ossFile.setFileName(fileName);
                ossFile.setFileSize(file.getSize());
                ossFile.setFileType(file.getContentType());
                ossFile.setDomain(minioClientConfig.getEndPoint());
                ossFile.setBucket(minioClientConfig.getBucketName());
                ossFile.setUrl(minioClientConfig.getEndPoint()+"/"+minioClientConfig.getBucketName()+"/"+fileName);
                fileSaveList.add(ossFile);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        fileService.saveBatch(fileSaveList);
        return fileSaveList;
    }

    /**
     * 下载文件
     **/
    public ResponseEntity<byte[]> download(String fileId) {
        ResponseEntity<byte[]> responseEntity = null;
        InputStream in = null;
        ByteArrayOutputStream out = null;
        try {
            OssFile ossFile = fileService.getById(fileId);
            in = minioClient.getObject(GetObjectArgs.builder().bucket(minioClientConfig.getBucketName()).object(ossFile.getFileName()).build());
            out = new ByteArrayOutputStream();
            IOUtils.copy(in, out);
            //封装返回值
            byte[] bytes = out.toByteArray();
            HttpHeaders headers = new HttpHeaders();
            try {
                headers.add("Content-Disposition", "attachment;filename=" + URLEncoder.encode(ossFile.getOriginalName(), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            headers.setContentLength(bytes.length);
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setAccessControlExposeHeaders(Arrays.asList("*"));
            responseEntity = new ResponseEntity<>(bytes, headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return responseEntity;
    }

    /**
     * 查看bucketName里面的文件对象
     **/
    public List<ObjectItemVo> listObjects(String bucketName) {
        Iterable<Result<Item>> results = minioClient.listObjects(
                ListObjectsArgs.builder().bucket(bucketName).build());
        List<ObjectItemVo> objectItems = new ArrayList<>();
        try {
            for (Result<Item> result : results) {
                Item item = result.get();
                ObjectItemVo objectItem = new ObjectItemVo();
                objectItem.setObjectName(item.objectName());
                objectItem.setSize(item.size());
                objectItems.add(objectItem);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return objectItems;
    }

    /**
     * 批量删除文件对象
     **/
    public Iterable<Result<DeleteError>> removeObjects(String bucketName, List<String> objects) {
        List<DeleteObject> dos = objects.stream().map(e -> new DeleteObject(e)).collect(Collectors.toList());
        Iterable<Result<DeleteError>> results = minioClient.removeObjects(RemoveObjectsArgs.builder().bucket(bucketName).objects(dos).build());
        return results;
    }

    /**
     * 获取文件URL
     **/
    public String getObjectUrl(String bucketName, String objectName) {
        GetObjectResponse object = null;
        try {
            object = minioClient.getObject(GetObjectArgs.builder().bucket(bucketName).object(objectName).build());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object.object();
    }

}
