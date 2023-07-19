package com.jyd.dto;

import com.jyd.entity.PortalUser;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 门户用户数据传输对象实体类
 *
 * @author 
 * @since 2023-07-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PortalUserDTO extends PortalUser {
	private static final long serialVersionUID = 1L;

}
