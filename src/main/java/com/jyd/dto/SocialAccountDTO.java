package com.jyd.dto;

import com.jyd.entity.SocialAccount;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 社交账号表数据传输对象实体类
 *
 * @author 
 * @since 2023-12-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SocialAccountDTO extends SocialAccount {
	private static final long serialVersionUID = 1L;

}
