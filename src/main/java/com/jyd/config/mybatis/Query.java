package com.jyd.config.mybatis;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 分页工具
 *
 * @author Chill
 */
@Data
@Accessors(chain = true)
@ApiModel(description = "查询条件")
public class Query {

	/**
	 * 当前页
	 */
	@ApiModelProperty(value = "当前页")
	private Integer current = 1;

	/**
	 * 每页的数量
	 */
	@ApiModelProperty(value = "每页的数量")
	private Integer size = 10;

	/**
	 * 正排序规则
	 */
	@ApiModelProperty(hidden = true)
	private String ascs;

	/**
	 * 倒排序规则
	 */
	@ApiModelProperty(hidden = true)
	private String descs;

	/**
	 * 默认查总数。开启后不查总数
	 */
	@ApiModelProperty(value = "是否查询总数，默认是")
	private Boolean searchCount = true;

}
