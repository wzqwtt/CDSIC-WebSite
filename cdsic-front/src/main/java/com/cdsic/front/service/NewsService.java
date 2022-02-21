package com.cdsic.front.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cdsic.common.utils.PageUtils;
import com.cdsic.front.entity.NewsEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author ZongqinWang
 * @email 1722249371@qq.com
 * @date 2022-02-10 14:45:34
 */
public interface NewsService extends IService<NewsEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 查出最近的n条新闻 按照时间排序
     * @return
     */
    List<NewsEntity> getRecentNews(int n);

    /**
     * 查出所有新闻，按照时间排序
     * @return
     */
    List<NewsEntity> getNewsOrderDescByDate();
}

