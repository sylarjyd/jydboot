package com.jyd.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 部门实体类
 *
 * @author 
 * @since 2023-12-01
 */
@Data
@TableName("t_sys_dept")
@ApiModel(value = "SysDept对象", description = "部门")
public class SysDept implements Serializable {

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
	* 部门编码
	*/
		@ApiModelProperty(value = "部门编码")
		private String deptCode;
	/**
	* 部门名称
	*/
		@ApiModelProperty(value = "部门名称")
		private String deptName;
	/**
	* 备注
	*/
		@ApiModelProperty(value = "备注")
		private String mark;
	/**
	* 上级部门
	*/
		@ApiModelProperty(value = "上级部门")
		private String parentId;


}
