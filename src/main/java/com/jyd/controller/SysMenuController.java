package com.jyd.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.jyd.config.mybatis.Condition;
import com.jyd.config.mybatis.Query;
import com.jyd.entity.SysMenu;
import com.jyd.service.ISysMenuService;
import com.jyd.vo.R;
import com.jyd.vo.SysMenuVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 权限 控制器
 *
 * @author
 * @since 2023-12-01
 */
@RestController
@AllArgsConstructor
@RequestMapping("/sysmenu")
@Api(value = "权限", tags = "权限接口")
public class SysMenuController {

	private ISysMenuService sysMenuService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入sysMenu")
	public R<SysMenu> detail(SysMenu sysMenu) {
		SysMenu detail = sysMenuService.getOne(Condition.getQueryWrapper(sysMenu));
		return R.data(detail);
	}

	/**
	 * 分页 权限
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入sysMenu")
	public R<IPage<SysMenu>> list(SysMenu sysMenu, Query query) {
		IPage<SysMenu> pages = sysMenuService.page(Condition.getPage(query), Condition.getQueryWrapper(sysMenu));
		return R.data(pages);
	}

	/**
	 * 自定义分页 权限
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入sysMenu")
	public R<IPage<SysMenuVO>> page(SysMenuVO sysMenu, Query query) {
		IPage<SysMenuVO> pages = sysMenuService.selectSysMenuPage(Condition.getPage(query), sysMenu);
		return R.data(pages);
	}

	/**
	 * 新增 权限
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入sysMenu")
	public R save(@Valid @RequestBody SysMenu sysMenu) {
		return R.status(sysMenuService.save(sysMenu));
	}

	/**
	 * 修改 权限
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入sysMenu")
	public R update(@Valid @RequestBody SysMenu sysMenu) {
		return R.status(sysMenuService.updateById(sysMenu));
	}

	/**
	 * 新增或修改 权限
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入sysMenu")
	public R submit(@Valid @RequestBody SysMenu sysMenu) {
		return R.status(sysMenuService.saveOrUpdate(sysMenu));
	}


	/**
	 * 删除 权限
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 8)
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestBody List<String> ids) {
		return R.status(sysMenuService.removeByIds(ids));
	}


}
