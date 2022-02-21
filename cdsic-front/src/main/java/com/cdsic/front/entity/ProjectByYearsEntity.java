package com.cdsic.front.entity;

import lombok.Data;

import java.util.List;

@Data
public class ProjectByYearsEntity {

    /**
     * 年份
     */
    private String year;

    /**
     * 该年份对应的project
     */
    private List<ProjectEntity> projectEntities;

    public ProjectByYearsEntity(String year, List<ProjectEntity> projectEntities) {
        this.year = year;
        this.projectEntities = projectEntities;
    }
}
