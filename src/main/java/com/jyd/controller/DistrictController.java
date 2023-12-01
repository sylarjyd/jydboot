package com.jyd.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.jyd.config.mybatis.Condition;
import com.jyd.config.mybatis.Query;
import com.jyd.entity.District;
import com.jyd.service.IDistrictService;
import com.jyd.vo.DistrictVO;
import com.jyd.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 区划 控制器
 *
 * @author
 * @since 2023-12-01
 */
@RestController
@AllArgsConstructor
@RequestMapping("/district")
@Api(value = "区划", tags = "区划接口")
public class DistrictController {

	private IDistrictService districtService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入district")
	public R<District> detail(District district) {
		District detail = districtService.getOne(Condition.getQueryWrapper(district));
		return R.data(detail);
	}

	/**
	 * 分页 区划
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入district")
	public R<IPage<District>> list(District district, Query query) {
		IPage<District> pages = districtService.page(Condition.getPage(query), Condition.getQueryWrapper(district));
		return R.data(pages);
	}

	/**
	 * 自定义分页 区划
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入district")
	public R<IPage<DistrictVO>> page(DistrictVO district, Query query) {
		IPage<DistrictVO> pages = districtService.selectDistrictPage(Condition.getPage(query), district);
		return R.data(pages);
	}

	/**
	 * 新增 区划
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入district")
	public R save(@Valid @RequestBody District district) {
		return R.status(districtService.save(district));
	}

	/**
	 * 修改 区划
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入district")
	public R update(@Valid @RequestBody District district) {
		return R.status(districtService.updateById(district));
	}

	/**
	 * 新增或修改 区划
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入district")
	public R submit(@Valid @RequestBody District district) {
		return R.status(districtService.saveOrUpdate(district));
	}


	/**
	 * 删除 区划
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 8)
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestBody List<String> ids) {
		return R.status(districtService.removeByIds(ids));
	}


}
