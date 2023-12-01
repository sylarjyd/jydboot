package com.jyd.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.jyd.config.mybatis.Condition;
import com.jyd.config.mybatis.Query;
import com.jyd.entity.SysUser;
import com.jyd.service.ISysUserService;
import com.jyd.vo.R;
import com.jyd.vo.SysUserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 系统用户 控制器
 *
 * @author
 * @since 2023-12-01
 */
@RestController
@AllArgsConstructor
@RequestMapping("/sysuser")
@Api(value = "系统用户", tags = "系统用户接口")
public class SysUserController {

	private ISysUserService sysUserService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入sysUser")
	public R<SysUser> detail(SysUser sysUser) {
		SysUser detail = sysUserService.getOne(Condition.getQueryWrapper(sysUser));
		return R.data(detail);
	}

	/**
	 * 分页 系统用户
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入sysUser")
	public R<IPage<SysUser>> list(SysUser sysUser, Query query) {
		IPage<SysUser> pages = sysUserService.page(Condition.getPage(query), Condition.getQueryWrapper(sysUser));
		return R.data(pages);
	}

	/**
	 * 自定义分页 系统用户
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入sysUser")
	public R<IPage<SysUserVO>> page(SysUserVO sysUser, Query query) {
		IPage<SysUserVO> pages = sysUserService.selectSysUserPage(Condition.getPage(query), sysUser);
		return R.data(pages);
	}

	/**
	 * 新增 系统用户
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入sysUser")
	public R save(@Valid @RequestBody SysUser sysUser) {
		return R.status(sysUserService.save(sysUser));
	}

	/**
	 * 修改 系统用户
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入sysUser")
	public R update(@Valid @RequestBody SysUser sysUser) {
		return R.status(sysUserService.updateById(sysUser));
	}

	/**
	 * 新增或修改 系统用户
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入sysUser")
	public R submit(@Valid @RequestBody SysUser sysUser) {
		return R.status(sysUserService.saveOrUpdate(sysUser));
	}


	/**
	 * 删除 系统用户
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 8)
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestBody List<String> ids) {
		return R.status(sysUserService.removeByIds(ids));
	}


}
