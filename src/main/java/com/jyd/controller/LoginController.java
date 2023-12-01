package com.jyd.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.jyd.entity.User;
import com.jyd.service.IUserService;
import com.jyd.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 门户登录注册 控制器
 *
 * @author
 * @since 2023-12-01
 */
@RestController
@AllArgsConstructor
@RequestMapping("/portal")
@Api(value = "门户登录注册", tags = "门户登录注册接口")
public class LoginController {

	private IUserService userService;

	/**
	 * 注册
	 */
	@PostMapping("/register")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "新增", notes = "传入User")
	public R register(@Valid @RequestBody User user) {
		return R.status(userService.save(user));
	}

	/**
	 * 登录
	 */
	@PostMapping("/login")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "登录", notes = "传入User")
	public R login(@Valid @RequestBody User user) {
		return R.status(userService.save(user));
	}

}
