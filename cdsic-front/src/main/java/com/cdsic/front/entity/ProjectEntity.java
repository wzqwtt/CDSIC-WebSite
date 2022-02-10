package com.cdsic.front.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author ZongqinWang
 * @email 1722249371@qq.com
 * @date 2022-02-10 14:45:34
 */
@Data
@TableName("c_project")
public class ProjectEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer pid;
	/**
	 * 成果发布时间
	 */
	private Date pdate;
	/**
	 * 成果标题
	 */
	private String ptitle;
	/**
	 * 成果代表性图片
	 */
	private String pimage;
	/**
	 * 成果发表平台
	 */
	private String pplatform;
	/**
	 * 成果参与研究人员
	 */
	private String pperson;
	/**
	 * 成果主要内容
	 */
	private String pcontent;
	/**
	 * 成果简要介绍
	 */
	private String psynopsis;
	/**
	 * 成果是否在轮播图中展示
	 */
	private Integer piscarousel;
	/**
	 * 如果展示轮播图，这里写入顺序，默认不展示（值为-1）
	 */
	private Integer porder;

}
