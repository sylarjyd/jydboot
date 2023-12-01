package com.jyd.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.jyd.config.mybatis.Condition;
import com.jyd.config.mybatis.Query;
import com.jyd.entity.SysNotice;
import com.jyd.service.ISysNoticeService;
import com.jyd.vo.R;
import com.jyd.vo.SysNoticeVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 新闻公告 控制器
 *
 * @author
 * @since 2023-12-01
 */
@RestController
@AllArgsConstructor
@RequestMapping("/sysnotice")
@Api(value = "新闻公告", tags = "新闻公告接口")
public class SysNoticeController {

	private ISysNoticeService sysNoticeService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入sysNotice")
	public R<SysNotice> detail(SysNotice sysNotice) {
		SysNotice detail = sysNoticeService.getOne(Condition.getQueryWrapper(sysNotice));
		return R.data(detail);
	}

	/**
	 * 分页 新闻公告
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入sysNotice")
	public R<IPage<SysNotice>> list(SysNotice sysNotice, Query query) {
		IPage<SysNotice> pages = sysNoticeService.page(Condition.getPage(query), Condition.getQueryWrapper(sysNotice));
		return R.data(pages);
	}

	/**
	 * 自定义分页 新闻公告
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入sysNotice")
	public R<IPage<SysNoticeVO>> page(SysNoticeVO sysNotice, Query query) {
		IPage<SysNoticeVO> pages = sysNoticeService.selectSysNoticePage(Condition.getPage(query), sysNotice);
		return R.data(pages);
	}

	/**
	 * 新增 新闻公告
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入sysNotice")
	public R save(@Valid @RequestBody SysNotice sysNotice) {
		return R.status(sysNoticeService.save(sysNotice));
	}

	/**
	 * 修改 新闻公告
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入sysNotice")
	public R update(@Valid @RequestBody SysNotice sysNotice) {
		return R.status(sysNoticeService.updateById(sysNotice));
	}

	/**
	 * 新增或修改 新闻公告
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入sysNotice")
	public R submit(@Valid @RequestBody SysNotice sysNotice) {
		return R.status(sysNoticeService.saveOrUpdate(sysNotice));
	}


	/**
	 * 删除 新闻公告
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 8)
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestBody List<String> ids) {
		return R.status(sysNoticeService.removeByIds(ids));
	}


}
