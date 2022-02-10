package com.cdsic.front.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdsic.front.entity.ProjectEntity;
import com.cdsic.front.service.ProjectService;
import com.cdsic.common.utils.PageUtils;
import com.cdsic.common.utils.R;



/**
 * 
 *
 * @author ZongqinWang
 * @email 1722249371@qq.com
 * @date 2022-02-10 14:45:34
 */
@RestController
@RequestMapping("front/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("front:project:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = projectService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{pid}")
    @RequiresPermissions("front:project:info")
    public R info(@PathVariable("pid") Integer pid){
		ProjectEntity project = projectService.getById(pid);

        return R.ok().put("project", project);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("front:project:save")
    public R save(@RequestBody ProjectEntity project){
		projectService.save(project);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("front:project:update")
    public R update(@RequestBody ProjectEntity project){
		projectService.updateById(project);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("front:project:delete")
    public R delete(@RequestBody Integer[] pids){
		projectService.removeByIds(Arrays.asList(pids));

        return R.ok();
    }

}
