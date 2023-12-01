package com.jyd.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.jyd.config.mybatis.Condition;
import com.jyd.config.mybatis.Query;
import com.jyd.entity.SysPost;
import com.jyd.service.ISysPostService;
import com.jyd.vo.R;
import com.jyd.vo.SysPostVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 岗位 控制器
 *
 * @author
 * @since 2023-12-01
 */
@RestController
@AllArgsConstructor
@RequestMapping("/syspost")
@Api(value = "岗位", tags = "岗位接口")
public class SysPostController {

	private ISysPostService sysPostService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入sysPost")
	public R<SysPost> detail(SysPost sysPost) {
		SysPost detail = sysPostService.getOne(Condition.getQueryWrapper(sysPost));
		return R.data(detail);
	}

	/**
	 * 分页 岗位
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入sysPost")
	public R<IPage<SysPost>> list(SysPost sysPost, Query query) {
		IPage<SysPost> pages = sysPostService.page(Condition.getPage(query), Condition.getQueryWrapper(sysPost));
		return R.data(pages);
	}

	/**
	 * 自定义分页 岗位
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入sysPost")
	public R<IPage<SysPostVO>> page(SysPostVO sysPost, Query query) {
		IPage<SysPostVO> pages = sysPostService.selectSysPostPage(Condition.getPage(query), sysPost);
		return R.data(pages);
	}

	/**
	 * 新增 岗位
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入sysPost")
	public R save(@Valid @RequestBody SysPost sysPost) {
		return R.status(sysPostService.save(sysPost));
	}

	/**
	 * 修改 岗位
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入sysPost")
	public R update(@Valid @RequestBody SysPost sysPost) {
		return R.status(sysPostService.updateById(sysPost));
	}

	/**
	 * 新增或修改 岗位
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入sysPost")
	public R submit(@Valid @RequestBody SysPost sysPost) {
		return R.status(sysPostService.saveOrUpdate(sysPost));
	}


	/**
	 * 删除 岗位
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 8)
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestBody List<String> ids) {
		return R.status(sysPostService.removeByIds(ids));
	}


}
