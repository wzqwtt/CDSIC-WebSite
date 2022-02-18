package com.cdsic.front.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

}