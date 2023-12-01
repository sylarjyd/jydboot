package com.jyd.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.jyd.config.mybatis.Condition;
import com.jyd.config.mybatis.Query;
import com.jyd.entity.SysDept;
import com.jyd.service.ISysDeptService;
import com.jyd.vo.R;
import com.jyd.vo.SysDeptVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 部门 控制器
 *
 * @author
 * @since 2023-12-01
 */
@RestController
@AllArgsConstructor
@RequestMapping("/sysdept")
@Api(value = "部门", tags = "部门接口")
public class SysDeptController {

	private ISysDeptService sysDeptService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入sysDept")
	public R<SysDept> detail(SysDept sysDept) {
		SysDept detail = sysDeptService.getOne(Condition.getQueryWrapper(sysDept));
		return R.data(detail);
	}

	/**
	 * 分页 部门
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入sysDept")
	public R<IPage<SysDept>> list(SysDept sysDept, Query query) {
		IPage<SysDept> pages = sysDeptService.page(Condition.getPage(query), Condition.getQueryWrapper(sysDept));
		return R.data(pages);
	}

	/**
	 * 自定义分页 部门
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入sysDept")
	public R<IPage<SysDeptVO>> page(SysDeptVO sysDept, Query query) {
		IPage<SysDeptVO> pages = sysDeptService.selectSysDeptPage(Condition.getPage(query), sysDept);
		return R.data(pages);
	}

	/**
	 * 新增 部门
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入sysDept")
	public R save(@Valid @RequestBody SysDept sysDept) {
		return R.status(sysDeptService.save(sysDept));
	}

	/**
	 * 修改 部门
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入sysDept")
	public R update(@Valid @RequestBody SysDept sysDept) {
		return R.status(sysDeptService.updateById(sysDept));
	}

	/**
	 * 新增或修改 部门
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入sysDept")
	public R submit(@Valid @RequestBody SysDept sysDept) {
		return R.status(sysDeptService.saveOrUpdate(sysDept));
	}


	/**
	 * 删除 部门
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 8)
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestBody List<String> ids) {
		return R.status(sysDeptService.removeByIds(ids));
	}


}
