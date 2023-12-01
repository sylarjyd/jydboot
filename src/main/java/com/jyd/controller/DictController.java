package com.jyd.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.jyd.config.mybatis.Condition;
import com.jyd.config.mybatis.Query;
import com.jyd.entity.Dict;
import com.jyd.service.IDictService;
import com.jyd.vo.DictVO;
import com.jyd.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 字典 控制器
 *
 * @author
 * @since 2023-12-01
 */
@RestController
@AllArgsConstructor
@RequestMapping("/dict")
@Api(value = "字典", tags = "字典接口")
public class DictController {

	private IDictService dictService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入dict")
	public R<Dict> detail(Dict dict) {
		Dict detail = dictService.getOne(Condition.getQueryWrapper(dict));
		return R.data(detail);
	}

	/**
	 * 分页 字典
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入dict")
	public R<IPage<Dict>> list(Dict dict, Query query) {
		IPage<Dict> pages = dictService.page(Condition.getPage(query), Condition.getQueryWrapper(dict));
		return R.data(pages);
	}

	/**
	 * 自定义分页 字典
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入dict")
	public R<IPage<DictVO>> page(DictVO dict, Query query) {
		IPage<DictVO> pages = dictService.selectDictPage(Condition.getPage(query), dict);
		return R.data(pages);
	}

	/**
	 * 新增 字典
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入dict")
	public R save(@Valid @RequestBody Dict dict) {
		return R.status(dictService.save(dict));
	}

	/**
	 * 修改 字典
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入dict")
	public R update(@Valid @RequestBody Dict dict) {
		return R.status(dictService.updateById(dict));
	}

	/**
	 * 新增或修改 字典
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入dict")
	public R submit(@Valid @RequestBody Dict dict) {
		return R.status(dictService.saveOrUpdate(dict));
	}


	/**
	 * 删除 字典
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 8)
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestBody List<String> ids) {
		return R.status(dictService.removeByIds(ids));
	}


}
