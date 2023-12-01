package com.jyd.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.jyd.config.mybatis.Condition;
import com.jyd.config.mybatis.Query;
import com.jyd.entity.SysRoleMenu;
import com.jyd.service.ISysRoleMenuService;
import com.jyd.vo.R;
import com.jyd.vo.SysRoleMenuVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 角色-权限 控制器
 *
 * @author
 * @since 2023-12-01
 */
@RestController
@AllArgsConstructor
@RequestMapping("/sysrolemenu")
@Api(value = "角色-权限", tags = "角色-权限接口")
public class SysRoleMenuController {

	private ISysRoleMenuService sysRoleMenuService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入sysRoleMenu")
	public R<SysRoleMenu> detail(SysRoleMenu sysRoleMenu) {
		SysRoleMenu detail = sysRoleMenuService.getOne(Condition.getQueryWrapper(sysRoleMenu));
		return R.data(detail);
	}

	/**
	 * 分页 角色-权限
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入sysRoleMenu")
	public R<IPage<SysRoleMenu>> list(SysRoleMenu sysRoleMenu, Query query) {
		IPage<SysRoleMenu> pages = sysRoleMenuService.page(Condition.getPage(query), Condition.getQueryWrapper(sysRoleMenu));
		return R.data(pages);
	}

	/**
	 * 自定义分页 角色-权限
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入sysRoleMenu")
	public R<IPage<SysRoleMenuVO>> page(SysRoleMenuVO sysRoleMenu, Query query) {
		IPage<SysRoleMenuVO> pages = sysRoleMenuService.selectSysRoleMenuPage(Condition.getPage(query), sysRoleMenu);
		return R.data(pages);
	}

	/**
	 * 新增 角色-权限
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入sysRoleMenu")
	public R save(@Valid @RequestBody SysRoleMenu sysRoleMenu) {
		return R.status(sysRoleMenuService.save(sysRoleMenu));
	}

	/**
	 * 修改 角色-权限
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入sysRoleMenu")
	public R update(@Valid @RequestBody SysRoleMenu sysRoleMenu) {
		return R.status(sysRoleMenuService.updateById(sysRoleMenu));
	}

	/**
	 * 新增或修改 角色-权限
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入sysRoleMenu")
	public R submit(@Valid @RequestBody SysRoleMenu sysRoleMenu) {
		return R.status(sysRoleMenuService.saveOrUpdate(sysRoleMenu));
	}


	/**
	 * 删除 角色-权限
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 8)
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestBody List<String> ids) {
		return R.status(sysRoleMenuService.removeByIds(ids));
	}


}
