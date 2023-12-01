package com.jyd.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 消息日志实体类
 *
 * @author 
 * @since 2023-12-01
 */
@Data
@TableName("t_message_log")
@ApiModel(value = "MessageLog对象", description = "消息日志")
public class MessageLog implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	* 主键
	*/
		@ApiModelProperty(value = "主键")
		private String id;
	/**
	* 创建时间
	*/
		@ApiModelProperty(value = "创建时间")
		private Date createTime;
	/**
	* 创建人
	*/
		@ApiModelProperty(value = "创建人")
		private String createUser;
	/**
	* 类型
	*/
		@ApiModelProperty(value = "类型")
		private Integer type;
	/**
	* 消息状态0成功1失败
	*/
		@ApiModelProperty(value = "消息状态0成功1失败")
		private Integer status;
	/**
	* 标题
	*/
		@ApiModelProperty(value = "标题")
		private String title;
	/**
	* 消息内容
	*/
		@ApiModelProperty(value = "消息内容")
		private String content;
	/**
	* 业务ID
	*/
		@ApiModelProperty(value = "业务ID")
		private String businessId;
	/**
	* 用户ID
	*/
		@ApiModelProperty(value = "用户ID")
		private String userId;


}
