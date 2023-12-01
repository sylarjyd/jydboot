package com.jyd.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.jyd.config.mybatis.Condition;
import com.jyd.config.mybatis.Query;
import com.jyd.entity.SysRole;
import com.jyd.service.ISysRoleService;
import com.jyd.vo.R;
import com.jyd.vo.SysRoleVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 角色 控制器
 *
 * @author
 * @since 2023-12-01
 */
@RestController
@AllArgsConstructor
@RequestMapping("/sysrole")
@Api(value = "角色", tags = "角色接口")
public class SysRoleController {

	private ISysRoleService sysRoleService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入sysRole")
	public R<SysRole> detail(SysRole sysRole) {
		SysRole detail = sysRoleService.getOne(Condition.getQueryWrapper(sysRole));
		return R.data(detail);
	}

	/**
	 * 分页 角色
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入sysRole")
	public R<IPage<SysRole>> list(SysRole sysRole, Query query) {
		IPage<SysRole> pages = sysRoleService.page(Condition.getPage(query), Condition.getQueryWrapper(sysRole));
		return R.data(pages);
	}

	/**
	 * 自定义分页 角色
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入sysRole")
	public R<IPage<SysRoleVO>> page(SysRoleVO sysRole, Query query) {
		IPage<SysRoleVO> pages = sysRoleService.selectSysRolePage(Condition.getPage(query), sysRole);
		return R.data(pages);
	}

	/**
	 * 新增 角色
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入sysRole")
	public R save(@Valid @RequestBody SysRole sysRole) {
		return R.status(sysRoleService.save(sysRole));
	}

	/**
	 * 修改 角色
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入sysRole")
	public R update(@Valid @RequestBody SysRole sysRole) {
		return R.status(sysRoleService.updateById(sysRole));
	}

	/**
	 * 新增或修改 角色
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入sysRole")
	public R submit(@Valid @RequestBody SysRole sysRole) {
		return R.status(sysRoleService.saveOrUpdate(sysRole));
	}


	/**
	 * 删除 角色
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 8)
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestBody List<String> ids) {
		return R.status(sysRoleService.removeByIds(ids));
	}


}
