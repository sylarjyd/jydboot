package com.jyd.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.jyd.config.mybatis.Condition;
import com.jyd.config.mybatis.Query;
import com.jyd.entity.SysLog;
import com.jyd.service.ISysLogService;
import com.jyd.vo.R;
import com.jyd.vo.SysLogVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 系统日志 控制器
 *
 * @author
 * @since 2023-12-01
 */
@RestController
@AllArgsConstructor
@RequestMapping("/syslog")
@Api(value = "系统日志", tags = "系统日志接口")
public class SysLogController {

	private ISysLogService sysLogService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入sysLog")
	public R<SysLog> detail(SysLog sysLog) {
		SysLog detail = sysLogService.getOne(Condition.getQueryWrapper(sysLog));
		return R.data(detail);
	}

	/**
	 * 分页 系统日志
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入sysLog")
	public R<IPage<SysLog>> list(SysLog sysLog, Query query) {
		IPage<SysLog> pages = sysLogService.page(Condition.getPage(query), Condition.getQueryWrapper(sysLog));
		return R.data(pages);
	}

	/**
	 * 自定义分页 系统日志
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入sysLog")
	public R<IPage<SysLogVO>> page(SysLogVO sysLog, Query query) {
		IPage<SysLogVO> pages = sysLogService.selectSysLogPage(Condition.getPage(query), sysLog);
		return R.data(pages);
	}

	/**
	 * 新增 系统日志
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入sysLog")
	public R save(@Valid @RequestBody SysLog sysLog) {
		return R.status(sysLogService.save(sysLog));
	}

	/**
	 * 修改 系统日志
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入sysLog")
	public R update(@Valid @RequestBody SysLog sysLog) {
		return R.status(sysLogService.updateById(sysLog));
	}

	/**
	 * 新增或修改 系统日志
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入sysLog")
	public R submit(@Valid @RequestBody SysLog sysLog) {
		return R.status(sysLogService.saveOrUpdate(sysLog));
	}


	/**
	 * 删除 系统日志
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 8)
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestBody List<String> ids) {
		return R.status(sysLogService.removeByIds(ids));
	}


}
