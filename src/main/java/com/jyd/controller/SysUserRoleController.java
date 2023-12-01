package com.jyd.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.jyd.config.mybatis.Condition;
import com.jyd.config.mybatis.Query;
import com.jyd.entity.SysUserRole;
import com.jyd.service.ISysUserRoleService;
import com.jyd.vo.R;
import com.jyd.vo.SysUserRoleVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 用户-角色 控制器
 *
 * @author
 * @since 2023-12-01
 */
@RestController
@AllArgsConstructor
@RequestMapping("/sysuserrole")
@Api(value = "用户-角色", tags = "用户-角色接口")
public class SysUserRoleController {

	private ISysUserRoleService sysUserRoleService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入sysUserRole")
	public R<SysUserRole> detail(SysUserRole sysUserRole) {
		SysUserRole detail = sysUserRoleService.getOne(Condition.getQueryWrapper(sysUserRole));
		return R.data(detail);
	}

	/**
	 * 分页 用户-角色
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入sysUserRole")
	public R<IPage<SysUserRole>> list(SysUserRole sysUserRole, Query query) {
		IPage<SysUserRole> pages = sysUserRoleService.page(Condition.getPage(query), Condition.getQueryWrapper(sysUserRole));
		return R.data(pages);
	}

	/**
	 * 自定义分页 用户-角色
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入sysUserRole")
	public R<IPage<SysUserRoleVO>> page(SysUserRoleVO sysUserRole, Query query) {
		IPage<SysUserRoleVO> pages = sysUserRoleService.selectSysUserRolePage(Condition.getPage(query), sysUserRole);
		return R.data(pages);
	}

	/**
	 * 新增 用户-角色
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入sysUserRole")
	public R save(@Valid @RequestBody SysUserRole sysUserRole) {
		return R.status(sysUserRoleService.save(sysUserRole));
	}

	/**
	 * 修改 用户-角色
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入sysUserRole")
	public R update(@Valid @RequestBody SysUserRole sysUserRole) {
		return R.status(sysUserRoleService.updateById(sysUserRole));
	}

	/**
	 * 新增或修改 用户-角色
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入sysUserRole")
	public R submit(@Valid @RequestBody SysUserRole sysUserRole) {
		return R.status(sysUserRoleService.saveOrUpdate(sysUserRole));
	}


	/**
	 * 删除 用户-角色
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 8)
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestBody List<String> ids) {
		return R.status(sysUserRoleService.removeByIds(ids));
	}


}
