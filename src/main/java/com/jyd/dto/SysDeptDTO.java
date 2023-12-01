package com.jyd.dto;

import com.jyd.entity.SysDept;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 部门数据传输对象实体类
 *
 * @author 
 * @since 2023-12-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysDeptDTO extends SysDept {
	private static final long serialVersionUID = 1L;

}
