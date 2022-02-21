package com.cdsic.front.service.impl;

import com.cdsic.front.entity.ProjectByYearsEntity;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cdsic.common.utils.PageUtils;
import com.cdsic.common.utils.Query;

import com.cdsic.front.dao.ProjectDao;
import com.cdsic.front.entity.ProjectEntity;
import com.cdsic.front.service.ProjectService;


@Service("projectService")
public class ProjectServiceImpl extends ServiceImpl<ProjectDao, ProjectEntity> implements ProjectService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ProjectEntity> page = this.page(
                new Query<ProjectEntity>().getPage(params),
                new QueryWrapper<ProjectEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<ProjectEntity> getCarouselProject() {
        List<ProjectEntity> projectEntities = baseMapper.selectList(new QueryWrapper<ProjectEntity>().eq("pisCarousel", 1).orderByDesc("porder"));
        return projectEntities;
    }

    @Override
    public List<ProjectEntity> getRecentProject(int n) {
        List<ProjectEntity> projectEntities = baseMapper.selectList(new QueryWrapper<ProjectEntity>().orderByDesc("pdate").last("limit " + n));
        return projectEntities;

    }

    @Override
    public List<ProjectByYearsEntity> getAllProjectByYear() {
        // 按照年份降序查找出所有project
        List<ProjectEntity> projectEntities = baseMapper.selectList(new QueryWrapper<ProjectEntity>().orderByDesc("pdate"));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");

        // 按照年份进行分组
        Map<String, List<ProjectEntity>> listMap = projectEntities.stream().collect(Collectors.groupingBy(project -> {
            return simpleDateFormat.format(project.getPdate());
        }));

        List<ProjectByYearsEntity> result = new ArrayList<>();

        for (Map.Entry<String, List<ProjectEntity>> entry : listMap.entrySet()) {
            result.add(new ProjectByYearsEntity(entry.getKey(), entry.getValue()));
        }

        return result;
    }

    @Override
    public ProjectEntity getProjectById(Integer pid) {
        return baseMapper.selectById(pid);
    }

}