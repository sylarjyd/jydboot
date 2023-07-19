package com.jyd.vo;

import com.jyd.entity.PortalUser;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 门户用户视图实体类
 *
 * @author 
 * @since 2023-07-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "PortalUserVO对象", description = "门户用户")
public class PortalUserVO extends PortalUser {
	private static final long serialVersionUID = 1L;

}
