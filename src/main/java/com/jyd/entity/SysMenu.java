package com.jyd.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 权限实体类
 *
 * @author
 * @since 2023-12-01
 */
@Data
@TableName("t_sys_menu")
@ApiModel(value = "SysMenu对象", description = "权限")
public class SysMenu implements Serializable {

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
	* 权限编码
	*/
		@ApiModelProperty(value = "权限编码")
		private String code;
	/**
	* 权限名称
	*/
		@ApiModelProperty(value = "权限名称")
		private String name;
	/**
	* 路由
	*/
		@ApiModelProperty(value = "路由")
		private String path;
	/**
	* 图标
	*/
		@ApiModelProperty(value = "图标")
		private String source;
	/**
	* 备注
	*/
		@ApiModelProperty(value = "备注")
		private String remark;
	/**
	* 序号
	*/
		@ApiModelProperty(value = "序号")
		private Integer sort;
	/**
	* 1菜单2按钮3数据
	*/
		@ApiModelProperty(value = "1菜单2按钮3数据")
		private Integer category;
	/**
	* 父级ID
	*/
		@ApiModelProperty(value = "父级ID")
		private String parentId;
	/**
	* 别名
	*/
		@ApiModelProperty(value = "别名")
		private String alias;
	/**
	* 操作按钮类型
	*/
		@ApiModelProperty(value = "操作按钮类型")
		private Integer action;

	/**
	* 是否打开新页面
	*/
		@ApiModelProperty(value = "是否打开新页面")
		private Integer isOpen;


}
