package com.jyd.vo;

import com.jyd.entity.SysDept;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 部门视图实体类
 *
 * @author 
 * @since 2023-12-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SysDeptVO对象", description = "部门")
public class SysDeptVO extends SysDept {
	private static final long serialVersionUID = 1L;

}
