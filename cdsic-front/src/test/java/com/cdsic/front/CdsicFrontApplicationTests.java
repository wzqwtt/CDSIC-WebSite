package com.cdsic.front;

import com.cdsic.front.entity.NewsEntity;
import com.cdsic.front.entity.ProjectEntity;
import com.cdsic.front.service.NewsService;
import com.cdsic.front.service.ProjectService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;


@SpringBootTest
class CdsicFrontApplicationTests {
    @Autowired
    ProjectService projectService;

    @Autowired
    NewsService newsService;

    @Test
    void getNewsTest(){
        List<NewsEntity> NewsEntities = newsService.getNewsOrderDescByDate();
        for (NewsEntity n : NewsEntities) {
            System.out.println(n.getNdate() + " " + n.getNtitle());
        }
    }

    @Test
    void getRecentNewsTest() {
        List<NewsEntity> list = newsService.getRecentNews();
        for (NewsEntity n : list) {
            System.out.println(n.getNdate() + " " + n.getNtitle());
        }
    }

    @Test
    void getCarouselProjectTest() {
        List<ProjectEntity> projectEntities = projectService.getCarouselProject();
        for(ProjectEntity project : projectEntities){
            System.out.println(project.getPiscarousel() + " " + project.getPorder() + " " + project.getPtitle());
        }
    }

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
