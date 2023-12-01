package com.jyd.dto;

import com.jyd.entity.SysPost;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 岗位数据传输对象实体类
 *
 * @author 
 * @since 2023-12-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysPostDTO extends SysPost {
	private static final long serialVersionUID = 1L;

}
