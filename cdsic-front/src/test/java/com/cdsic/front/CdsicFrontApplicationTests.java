package com.cdsic.front;

import com.cdsic.front.entity.ProjectEntity;
import com.cdsic.front.service.ProjectService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


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


}
