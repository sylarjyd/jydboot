package com.jyd.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 字典实体类
 *
 * @author 
 * @since 2023-12-01
 */
@Data
@TableName("t_dict")
@ApiModel(value = "Dict对象", description = "字典")
public class Dict implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	* 主键
	*/
		@ApiModelProperty(value = "主键")
		private String id;
	/**
	* 字典码
	*/
		@ApiModelProperty(value = "字典码")
		private String code;
	/**
	* 字典名称
	*/
		@ApiModelProperty(value = "字典名称")
		private String dictKey;
	/**
	* 字典值
	*/
		@ApiModelProperty(value = "字典值")
		private String dictValue;
	/**
	* 排序
	*/
		@ApiModelProperty(value = "排序")
		private Integer sort;
	/**
	* 字典备注
	*/
		@ApiModelProperty(value = "字典备注")
		private String remark;
	/**
	* 是否已删除0正常1删除
	*/
		@ApiModelProperty(value = "是否已删除0正常1删除")
		private Integer deleted;


}
