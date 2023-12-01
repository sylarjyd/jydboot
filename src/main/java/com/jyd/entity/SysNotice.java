package com.jyd.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 新闻公告实体类
 *
 * @author 
 * @since 2023-12-01
 */
@Data
@TableName("t_sys_notice")
@ApiModel(value = "SysNotice对象", description = "新闻公告")
public class SysNotice implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	* ID
	*/
		@ApiModelProperty(value = "ID")
		private String id;
	/**
	* 创建时间
	*/
		@ApiModelProperty(value = "创建时间")
		private Date createTime;
	/**
	* 更新时间
	*/
		@ApiModelProperty(value = "更新时间")
		private Date updateTime;
	/**
	* 创建人
	*/
		@ApiModelProperty(value = "创建人")
		private String createUser;
	/**
	* 更新人
	*/
		@ApiModelProperty(value = "更新人")
		private String updateUser;
	/**
	* 状态 0正常 1锁定
	*/
		@ApiModelProperty(value = "状态 0正常 1锁定")
		private Integer status;
	/**
	* 删除标记 0正常 1删除
	*/
		@ApiModelProperty(value = "删除标记 0正常 1删除")
		private Integer deleted;
	/**
	* 内容
	*/
		@ApiModelProperty(value = "内容")
		private String content;
	/**
	* 标题
	*/
		@ApiModelProperty(value = "标题")
		private String title;
	/**
	* 副标题
	*/
		@ApiModelProperty(value = "副标题")
		private String subTitle;
	/**
	* 发布人
	*/
		@ApiModelProperty(value = "发布人")
		private String postUser;
	/**
	* 发布时间
	*/
		@ApiModelProperty(value = "发布时间")
		private Date postTime;
	/**
	* 来源
	*/
		@ApiModelProperty(value = "来源")
		private String source;
	/**
	* 类型1、新闻 2通知公告
	*/
		@ApiModelProperty(value = "类型1、新闻 2通知公告")
		private Integer type;


}
