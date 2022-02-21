package com.cdsic.front.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cdsic.common.utils.PageUtils;
import com.cdsic.front.entity.ProjectByYearsEntity;
import com.cdsic.front.entity.ProjectEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author ZongqinWang
 * @email 1722249371@qq.com
 * @date 2022-02-10 14:45:34
 */
public interface ProjectService extends IService<ProjectEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 获取在首页展示的Project
     * @return
     */
    List<ProjectEntity> getCarouselProject();

    /**
     * 获取距离现在最近的N条Project
     * @return
     */
    List<ProjectEntity> getRecentProject(int n);

    /**
     * 按照年份查找
     * @return
     */
    List<ProjectByYearsEntity> getAllProjectByYear();
}

