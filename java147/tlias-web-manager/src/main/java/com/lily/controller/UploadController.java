package com.lily.controller;

import com.lily.utils.AliOSSProperties;
import com.lily.entity.Result;
import com.lily.utils.AliyunOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Slf4j
public class UploadController {
    /*@PostMapping("/upload")
    public Result upload(String username, Integer age, MultipartFile file) throws IOException {
        log.info("参数：{},{},{}",username, age, file.getOriginalFilename());
        //1.获取原始文件名
        String originalFilename = file.getOriginalFilename();
        //2.用UUID随机生成字符串
        String fileName= UUID.randomUUID()+originalFilename.substring(originalFilename.lastIndexOf("."));
        //3.将文件上传到本地
        file.transferTo(new File("D:/"+fileName));
        return Result.success(fileName);
    }*/

    /*private String endpoint="https://oss-cn-beijing.aliyuncs.com";
    private String bucketName="lily-java147";*/

    /*@Value("${aliyun.oss.endpoint}")
    private String endpoint;
    @Value("${aliyun.oss.bucket}")
    private String bucketName;*/

    @Autowired
    private AliOSSProperties aliOSSProperties;

    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws Exception {
        //1.获取原始文件名，截取文件名后缀
        String originalFilename = file.getOriginalFilename();
        log.info("原文件名：{}",originalFilename);
        //2.用UUID随机生成字符串
        String extName= originalFilename.substring(originalFilename.lastIndexOf("."));
        String url = AliyunOSSUtils.upload(aliOSSProperties.getEndpoint(), aliOSSProperties.getBucket(), file.getBytes(), extName);

        return Result.success(url);
    }
}
