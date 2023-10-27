package com.jyd.controller.web;

import com.jyd.config.mybatis.Condition;
import com.jyd.config.mybatis.Query;
import com.jyd.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import lombok.AllArgsConstructor;
import javax.validation.Valid;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.web.bind.annotation.*;
import com.jyd.entity.PortalUser;
import com.jyd.vo.PortalUserVO;
import com.jyd.service.IPortalUserService;

import java.util.List;

/**
 * 门户用户 控制器
 *
 * @author
 * @since 2023-07-19
 */
@RestController
@AllArgsConstructor
@RequestMapping("/portaluser")
@Api(value = "门户用户", tags = "门户用户接口")
public class PortalUserController {

	private IPortalUserService portalUserService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入portalUser")
	public R<PortalUser> detail(PortalUser portalUser) {
		PortalUser detail = portalUserService.getOne(Condition.getQueryWrapper(portalUser));
		return R.data(detail);
	}

	/**
	 * 分页 门户用户
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入portalUser")
	public R<IPage<PortalUser>> list(PortalUser portalUser, Query query) {
		IPage<PortalUser> pages = portalUserService.page(Condition.getPage(query), Condition.getQueryWrapper(portalUser));
		return R.data(pages);
	}

	/**
	 * 自定义分页 门户用户
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入portalUser")
	public R<IPage<PortalUserVO>> page(PortalUserVO portalUser, Query query) {
		IPage<PortalUserVO> pages = portalUserService.selectPortalUserPage(Condition.getPage(query), portalUser);
		return R.data(pages);
	}

	/**
	 * 新增 门户用户
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入portalUser")
	public R save(@Valid @RequestBody PortalUser portalUser) {
		return R.status(portalUserService.save(portalUser));
	}

	/**
	 * 修改 门户用户
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入portalUser")
	public R update(@Valid @RequestBody PortalUser portalUser) {
		return R.status(portalUserService.updateById(portalUser));
	}

	/**
	 * 新增或修改 门户用户
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入portalUser")
	public R submit(@Valid @RequestBody PortalUser portalUser) {
		return R.status(portalUserService.saveOrUpdate(portalUser));
	}


	/**
	 * 删除 门户用户
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 8)
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestBody List<String> ids) {
		return R.status(portalUserService.removeByIds(ids));
	}


}
