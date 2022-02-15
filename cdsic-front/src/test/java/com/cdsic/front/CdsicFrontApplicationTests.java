package com.cdsic.front;

import com.aliyun.oss.*;
import com.cdsic.front.entity.ProjectEntity;
import com.cdsic.front.service.ProjectService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@SpringBootTest
class CdsicFrontApplicationTests {
    @Autowired
    ProjectService projectService;

    @Test
    void contextLoads() {

        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setPtitle("abc");
        projectEntity.setPcontent("abc");
        projectEntity.setPimage("abc");
        projectEntity.setPplatform("abc");
        projectEntity.setPperson("abc");
        projectEntity.setPsynopsis("abc");

        boolean save = projectService.save(projectEntity);
        if (save) {
            System.out.println("保存成功！！");
        }
    }

    @Autowired
    OSSClient ossClient;

    // 测试阿里云OSS文件上传
    @Test
    public void testUpload() throws FileNotFoundException {
        InputStream inputStream = new FileInputStream("D:\\img\\e679fadb066afdac7013c1240749bf4.jpg");

        ossClient.putObject("cdsic","ab.jpg",inputStream);

        ossClient.shutdown();
        System.out.println("上传成功！");
    }

}
