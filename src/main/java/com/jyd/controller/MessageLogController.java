package com.jyd.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.jyd.config.mybatis.Condition;
import com.jyd.config.mybatis.Query;
import com.jyd.entity.MessageLog;
import com.jyd.service.IMessageLogService;
import com.jyd.vo.MessageLogVO;
import com.jyd.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 消息日志 控制器
 *
 * @author
 * @since 2023-12-01
 */
@RestController
@AllArgsConstructor
@RequestMapping("/messagelog")
@Api(value = "消息日志", tags = "消息日志接口")
public class MessageLogController {

	private IMessageLogService messageLogService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入messageLog")
	public R<MessageLog> detail(MessageLog messageLog) {
		MessageLog detail = messageLogService.getOne(Condition.getQueryWrapper(messageLog));
		return R.data(detail);
	}

	/**
	 * 分页 消息日志
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入messageLog")
	public R<IPage<MessageLog>> list(MessageLog messageLog, Query query) {
		IPage<MessageLog> pages = messageLogService.page(Condition.getPage(query), Condition.getQueryWrapper(messageLog));
		return R.data(pages);
	}

	/**
	 * 自定义分页 消息日志
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入messageLog")
	public R<IPage<MessageLogVO>> page(MessageLogVO messageLog, Query query) {
		IPage<MessageLogVO> pages = messageLogService.selectMessageLogPage(Condition.getPage(query), messageLog);
		return R.data(pages);
	}

	/**
	 * 新增 消息日志
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入messageLog")
	public R save(@Valid @RequestBody MessageLog messageLog) {
		return R.status(messageLogService.save(messageLog));
	}

	/**
	 * 修改 消息日志
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入messageLog")
	public R update(@Valid @RequestBody MessageLog messageLog) {
		return R.status(messageLogService.updateById(messageLog));
	}

	/**
	 * 新增或修改 消息日志
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入messageLog")
	public R submit(@Valid @RequestBody MessageLog messageLog) {
		return R.status(messageLogService.saveOrUpdate(messageLog));
	}


	/**
	 * 删除 消息日志
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 8)
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestBody List<String> ids) {
		return R.status(messageLogService.removeByIds(ids));
	}


}
