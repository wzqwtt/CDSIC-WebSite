package com.cdsic.front;

import com.cdsic.front.entity.NewsEntity;
import com.cdsic.front.entity.ProjectByYearsEntity;
import com.cdsic.front.entity.ProjectEntity;
import com.cdsic.front.service.NewsService;
import com.cdsic.front.service.ProjectService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@SpringBootTest
class CdsicFrontApplicationTests {
    @Autowired
    ProjectService projectService;

    @Autowired
    NewsService newsService;

    @Test
    void getProjectByYear() {

        List<ProjectByYearsEntity> projectByYearsEntities = projectService.getAllProjectByYear();

        for (ProjectByYearsEntity entity : projectByYearsEntities) {
            System.out.println(entity.getYear());
            for (ProjectEntity project : entity.getProjectEntities()) {
                System.out.println(project.getPdate() + " " + project.getPtitle());
            }
            System.out.println("-------------------------------");
        }

    }

    @Test
    void getNewsTest() {
        List<NewsEntity> NewsEntities = newsService.getNewsOrderDescByDate();
        SimpleDateFormat year = new SimpleDateFormat("yyyy");
        for (NewsEntity n : NewsEntities) {
            // 测试输出年份
            System.out.println(year.format(n.getNdate()));
        }
    }

    @Test
    void getRecentNewsTest() {
        List<NewsEntity> list = newsService.getRecentNews(3);
        for (NewsEntity n : list) {
            System.out.println(n.getNdate() + " " + n.getNtitle());
        }
    }

    @Test
    void getCarouselProjectTest() {
        List<ProjectEntity> projectEntities = projectService.getCarouselProject();
        for (ProjectEntity project : projectEntities) {
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
