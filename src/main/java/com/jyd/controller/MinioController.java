package com.jyd.controller;

import com.jyd.config.minio.MinioUtil;
import com.jyd.vo.R;
import io.minio.Result;
import io.minio.messages.DeleteError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/minio")
public class MinioController {

    @Autowired
    private MinioUtil minioUtil;

    /**
     * 上传
     * @param multipartFile
     * @return
     * @throws Exception
     */
    @PostMapping("/upload")
    public R<?> upload(@RequestParam("file") MultipartFile multipartFile) throws Exception {
        return R.data(minioUtil.upload(multipartFile));
    }

    /**
     * 下载文件
     * @param fileName
     * @param response
     */
    @GetMapping("/download")
    public void download(@RequestParam("fileName")String fileName, HttpServletResponse response) {
        minioUtil.download(fileName);
    }

    /**
     * 创建存储桶
     * @param bucketName
     * @return
     * @throws Exception
     */
    @GetMapping("/createBucket")
    public R<?> createBucket(String bucketName) throws Exception {
        return R.data(minioUtil.makeBucket(bucketName));
    }

    /**
     * 删除存储桶
     * @param bucketName
     * @return
     * @throws Exception
     */
    @GetMapping("/deleteBucket")
    public R<?> deleteBucket(String bucketName) throws Exception {
        return R.data(minioUtil.removeBucket(bucketName));
    }

    /**
     * 列出存储桶中的所有对象名称
     * @param bucketName
     * @return
     * @throws Exception
     */
    @GetMapping("/listObjectNames")
    public R<?> listObjectNames(String bucketName) throws Exception {
        return R.data(minioUtil.listObjects(bucketName));
    }

    /**
     * 批量删除文件对象
     * @param bucketName
     * @param objectNameList
     * @return
     * @throws Exception
     */
    @PostMapping("/removeObject")
    public R<?> removeObject(String bucketName, List<String> objectNameList) throws Exception {
        Iterable<Result<DeleteError>> results = minioUtil.removeObjects(bucketName, objectNameList);
        return R.data(results);
    }

    /**
     * 文件访问路径
     */
    @GetMapping("/getObjectUrl")
    public R<?> getObjectUrl(String bucketName,String id) throws Exception {
        return R.data(minioUtil.getObjectUrl(bucketName,id));
    }
}
