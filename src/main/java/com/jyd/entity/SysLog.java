package com.jyd.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 系统日志实体类
 *
 * @author 
 * @since 2023-12-01
 */
@Data
@TableName("t_sys_log")
@ApiModel(value = "SysLog对象", description = "系统日志")
public class SysLog implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	* 主键
	*/
		@ApiModelProperty(value = "主键")
		private String id;
	/**
	* 服务器IP地址
	*/
		@ApiModelProperty(value = "服务器IP地址")
		private String serverIp;
	/**
	* 操作地址ip
	*/
		@ApiModelProperty(value = "操作地址ip")
		private String remoteIp;
	/**
	* 服务名称
	*/
		@ApiModelProperty(value = "服务名称")
		private String serviceName;
	/**
	* 系统模块
	*/
		@ApiModelProperty(value = "系统模块")
		private String optModule;
	/**
	* 操作类型
	*/
		@ApiModelProperty(value = "操作类型")
		private String optType;
	/**
	* 日志类型1管理端2门户3移动端
	*/
		@ApiModelProperty(value = "日志类型1管理端2门户3移动端")
		private String type;
	/**
	* 请求方法
	*/
		@ApiModelProperty(value = "请求方法")
		private String method;
	/**
	* 请求路径
	*/
		@ApiModelProperty(value = "请求路径")
		private String requestUri;
	/**
	* 返回结果
	*/
		@ApiModelProperty(value = "返回结果")
		private String response;
	/**
	* 方法名
	*/
		@ApiModelProperty(value = "方法名")
		private String methodName;
	/**
	* 方法类
	*/
		@ApiModelProperty(value = "方法类")
		private String methodClass;
	/**
	* 操作提交的数据
	*/
		@ApiModelProperty(value = "操作提交的数据")
		private String params;
	/**
	* 操作状态0成功1失败
	*/
		@ApiModelProperty(value = "操作状态0成功1失败")
		private Integer status;
	/**
	* 创建者
	*/
		@ApiModelProperty(value = "创建者")
		private String createUser;
	/**
	* 创建时间
	*/
		@ApiModelProperty(value = "创建时间")
		private Date createTime;


}
