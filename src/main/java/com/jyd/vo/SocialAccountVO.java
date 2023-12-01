package com.jyd.vo;

import com.jyd.entity.SocialAccount;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 社交账号表视图实体类
 *
 * @author 
 * @since 2023-12-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SocialAccountVO对象", description = "社交账号表")
public class SocialAccountVO extends SocialAccount {
	private static final long serialVersionUID = 1L;

}
