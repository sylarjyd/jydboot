package com.jyd.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.jyd.config.mybatis.Condition;
import com.jyd.config.mybatis.Query;
import com.jyd.entity.AuditLog;
import com.jyd.service.IAuditLogService;
import com.jyd.vo.AuditLogVO;
import com.jyd.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 审核日志 控制器
 *
 * @author
 * @since 2023-12-01
 */
@RestController
@AllArgsConstructor
@RequestMapping("/auditlog")
@Api(value = "审核日志", tags = "审核日志接口")
public class AuditLogController {

	private IAuditLogService auditLogService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入auditLog")
	public R<AuditLog> detail(AuditLog auditLog) {
		AuditLog detail = auditLogService.getOne(Condition.getQueryWrapper(auditLog));
		return R.data(detail);
	}

	/**
	 * 分页 审核日志
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入auditLog")
	public R<IPage<AuditLog>> list(AuditLog auditLog, Query query) {
		IPage<AuditLog> pages = auditLogService.page(Condition.getPage(query), Condition.getQueryWrapper(auditLog));
		return R.data(pages);
	}

	/**
	 * 自定义分页 审核日志
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入auditLog")
	public R<IPage<AuditLogVO>> page(AuditLogVO auditLog, Query query) {
		IPage<AuditLogVO> pages = auditLogService.selectAuditLogPage(Condition.getPage(query), auditLog);
		return R.data(pages);
	}

	/**
	 * 新增 审核日志
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入auditLog")
	public R save(@Valid @RequestBody AuditLog auditLog) {
		return R.status(auditLogService.save(auditLog));
	}

	/**
	 * 修改 审核日志
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入auditLog")
	public R update(@Valid @RequestBody AuditLog auditLog) {
		return R.status(auditLogService.updateById(auditLog));
	}

	/**
	 * 新增或修改 审核日志
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入auditLog")
	public R submit(@Valid @RequestBody AuditLog auditLog) {
		return R.status(auditLogService.saveOrUpdate(auditLog));
	}


	/**
	 * 删除 审核日志
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 8)
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestBody List<String> ids) {
		return R.status(auditLogService.removeByIds(ids));
	}


}
