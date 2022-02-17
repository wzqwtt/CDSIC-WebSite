package com.cdsic.front.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cdsic.common.utils.PageUtils;
import com.cdsic.common.utils.Query;

import com.cdsic.front.dao.NewsDao;
import com.cdsic.front.entity.NewsEntity;
import com.cdsic.front.service.NewsService;


@Service("newsService")
public class NewsServiceImpl extends ServiceImpl<NewsDao, NewsEntity> implements NewsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<NewsEntity> page = this.page(
                new Query<NewsEntity>().getPage(params),
                new QueryWrapper<NewsEntity>()
        );
//        for (NewsEntity record : page.getRecords()) {
//            System.out.println(record.getNdate());
//        }
        return new PageUtils(page);
    }

}