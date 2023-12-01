package com.jyd.dto;

import com.jyd.entity.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 门户用户数据传输对象实体类
 *
 * @author 
 * @since 2023-12-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserDTO extends User {
	private static final long serialVersionUID = 1L;

}
