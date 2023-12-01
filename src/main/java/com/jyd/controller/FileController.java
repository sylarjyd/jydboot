package com.jyd.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.jyd.config.mybatis.Condition;
import com.jyd.config.mybatis.Query;
import com.jyd.entity.File;
import com.jyd.service.IFileService;
import com.jyd.vo.FileVO;
import com.jyd.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 文件存储 控制器
 *
 * @author
 * @since 2023-12-01
 */
@RestController
@AllArgsConstructor
@RequestMapping("/file")
@Api(value = "文件存储", tags = "文件存储接口")
public class FileController {

	private IFileService fileService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入file")
	public R<File> detail(File file) {
		File detail = fileService.getOne(Condition.getQueryWrapper(file));
		return R.data(detail);
	}

	/**
	 * 分页 文件存储
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入file")
	public R<IPage<File>> list(File file, Query query) {
		IPage<File> pages = fileService.page(Condition.getPage(query), Condition.getQueryWrapper(file));
		return R.data(pages);
	}

	/**
	 * 自定义分页 文件存储
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入file")
	public R<IPage<FileVO>> page(FileVO file, Query query) {
		IPage<FileVO> pages = fileService.selectFilePage(Condition.getPage(query), file);
		return R.data(pages);
	}

	/**
	 * 新增 文件存储
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入file")
	public R save(@Valid @RequestBody File file) {
		return R.status(fileService.save(file));
	}

	/**
	 * 修改 文件存储
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入file")
	public R update(@Valid @RequestBody File file) {
		return R.status(fileService.updateById(file));
	}

	/**
	 * 新增或修改 文件存储
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入file")
	public R submit(@Valid @RequestBody File file) {
		return R.status(fileService.saveOrUpdate(file));
	}


	/**
	 * 删除 文件存储
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 8)
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestBody List<String> ids) {
		return R.status(fileService.removeByIds(ids));
	}


}
