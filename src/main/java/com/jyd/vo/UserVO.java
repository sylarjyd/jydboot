package com.jyd.vo;

import com.jyd.entity.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 门户用户视图实体类
 *
 * @author 
 * @since 2023-12-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "UserVO对象", description = "门户用户")
public class UserVO extends User {
	private static final long serialVersionUID = 1L;

}
