package com.cdsic.front.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cdsic.common.utils.PageUtils;
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

    List<ProjectEntity> getCarouselProject();
}

