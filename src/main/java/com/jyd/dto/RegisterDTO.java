package com.jyd.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 注册
 */
@Data
public class RegisterDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String userName;
	private String password;
}
