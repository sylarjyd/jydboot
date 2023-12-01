package com.jyd.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 文件存储实体类
 *
 * @author 
 * @since 2023-12-01
 */
@Data
@TableName("t_file")
@ApiModel(value = "File对象", description = "文件存储")
public class File implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	* 主键
	*/
		@ApiModelProperty(value = "主键")
		private String id;
	/**
	* 资源编号
	*/
		@ApiModelProperty(value = "资源编号")
		private String fileName;
	/**
	* 文件名称
	*/
		@ApiModelProperty(value = "文件名称")
		private String originalName;
	/**
	* 文件类型后缀
	*/
		@ApiModelProperty(value = "文件类型后缀")
		private String fileType;
	/**
	* 文件大小KB
	*/
		@ApiModelProperty(value = "文件大小KB")
		private Long fileSize;
	/**
	* 是否需要鉴权，1是，0否，默认0
	*/
		@ApiModelProperty(value = "是否需要鉴权，1是，0否，默认0")
		private Integer auth;
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
