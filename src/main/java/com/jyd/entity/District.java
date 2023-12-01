package com.jyd.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 区划实体类
 *
 * @author
 * @since 2023-12-01
 */
@Data
@TableName("t_district")
@ApiModel(value = "District对象", description = "区划")
public class District implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	* 主键
	*/
		@ApiModelProperty(value = "主键")
		private String id;
	/**
	* 区划代码
	*/
		@ApiModelProperty(value = "区划代码")
		private String districtCode;
	/**
	* 区划名称
	*/
		@ApiModelProperty(value = "区划名称")
		private String districtName;
	/**
	* 父级id
	*/
		@ApiModelProperty(value = "父级id")
		private String parentId;
	/**
	* 行政级别
	*/
		@ApiModelProperty(value = "行政级别")
		private String levelCode;
	/**
	* 排序
	*/
		@ApiModelProperty(value = "排序")
		private Integer sort;
	/**
	* 创建人
	*/
		@ApiModelProperty(value = "创建人")
		private String createUser;
	/**
	* 创建时间
	*/
		@ApiModelProperty(value = "创建时间")
		private Date createTime;
	/**
	* 修改人
	*/
		@ApiModelProperty(value = "修改人")
		private String updateUser;
	/**
	* 修改时间
	*/
		@ApiModelProperty(value = "修改时间")
		private Date updateTime;
	/**
	* 状态
	*/
		@ApiModelProperty(value = "状态")
		private Integer status;
	/**
	* 是否已删除
	*/
		@ApiModelProperty(value = "是否已删除")
		private Integer deleted;


}
