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
@TableName("c_news")
public class NewsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer nid;
	/**
	 * 新闻时间
	 */
	private Date ndate;
	/**
	 * 新闻标题
	 */
	private String ntitle;
	/**
	 * 新闻内容
	 */
	private String ncontent;
	/**
	 * 新闻简要介绍
	 */
	private String nsynopsis;

}
