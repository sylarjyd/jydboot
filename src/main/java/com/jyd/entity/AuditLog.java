package com.jyd.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 审核日志实体类
 *
 * @author
 * @since 2023-12-01
 */
@Data
@TableName("t_audit_log")
@ApiModel(value = "AuditLog对象", description = "审核日志")
public class AuditLog implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	* 主键
	*/
		@ApiModelProperty(value = "主键")
		private String id;
	/**
	* 审核时间
	*/
		@ApiModelProperty(value = "审核时间")
		private Date createTime;
	/**
	* 审核人ID
	*/
		@ApiModelProperty(value = "审核人ID")
		private String createUser;
	/**
	* 审核人姓名
	*/
		@ApiModelProperty(value = "审核人姓名")
		private String createUserName;
	/**
	* 审核部门ID
	*/
		@ApiModelProperty(value = "审核部门ID")
		private String createDept;
	/**
	* 审核部门名称
	*/
		@ApiModelProperty(value = "审核部门名称")
		private String createDeptName;
	/**
	* 类型
	*/
		@ApiModelProperty(value = "类型")
		private Integer type;
	/**
	* 审核状态1通过2不通过3退回
	*/
		@ApiModelProperty(value = "审核状态1通过2不通过3退回")
		private Integer status;
	/**
	* 审核意见
	*/
		@ApiModelProperty(value = "审核意见")
		private String remark;
	/**
	* 业务ID
	*/
		@ApiModelProperty(value = "业务ID")
		private String businessId;


}
