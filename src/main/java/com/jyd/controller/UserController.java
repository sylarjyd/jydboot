package com.jyd.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.jyd.config.mybatis.Condition;
import com.jyd.config.mybatis.Query;
import com.jyd.entity.User;
import com.jyd.service.IUserService;
import com.jyd.vo.R;
import com.jyd.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 门户用户 控制器
 *
 * @author
 * @since 2023-12-01
 */
@RestController
@AllArgsConstructor
@RequestMapping("/user")
@Api(value = "门户用户", tags = "门户用户接口")
public class UserController {

	private IUserService userService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入user")
	public R<User> detail(User user) {
		User detail = userService.getOne(Condition.getQueryWrapper(user));
		return R.data(detail);
	}

	/**
	 * 分页 门户用户
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入user")
	public R<IPage<User>> list(User user, Query query) {
		IPage<User> pages = userService.page(Condition.getPage(query), Condition.getQueryWrapper(user));
		return R.data(pages);
	}

	/**
	 * 自定义分页 门户用户
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入user")
	public R<IPage<UserVO>> page(UserVO user, Query query) {
		IPage<UserVO> pages = userService.selectUserPage(Condition.getPage(query), user);
		return R.data(pages);
	}

	/**
	 * 新增 门户用户
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入user")
	public R save(@Valid @RequestBody User user) {
		return R.status(userService.save(user));
	}

	/**
	 * 修改 门户用户
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入user")
	public R update(@Valid @RequestBody User user) {
		return R.status(userService.updateById(user));
	}

	/**
	 * 新增或修改 门户用户
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入user")
	public R submit(@Valid @RequestBody User user) {
		return R.status(userService.saveOrUpdate(user));
	}


	/**
	 * 删除 门户用户
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 8)
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestBody List<String> ids) {
		return R.status(userService.removeByIds(ids));
	}


}
