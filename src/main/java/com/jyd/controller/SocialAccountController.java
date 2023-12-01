package com.jyd.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.jyd.config.mybatis.Condition;
import com.jyd.config.mybatis.Query;
import com.jyd.entity.SocialAccount;
import com.jyd.service.ISocialAccountService;
import com.jyd.vo.R;
import com.jyd.vo.SocialAccountVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 社交账号表 控制器
 *
 * @author
 * @since 2023-12-01
 */
@RestController
@AllArgsConstructor
@RequestMapping("/socialaccount")
@Api(value = "社交账号表", tags = "社交账号表接口")
public class SocialAccountController {

	private ISocialAccountService socialAccountService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入socialAccount")
	public R<SocialAccount> detail(SocialAccount socialAccount) {
		SocialAccount detail = socialAccountService.getOne(Condition.getQueryWrapper(socialAccount));
		return R.data(detail);
	}

	/**
	 * 分页 社交账号表
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入socialAccount")
	public R<IPage<SocialAccount>> list(SocialAccount socialAccount, Query query) {
		IPage<SocialAccount> pages = socialAccountService.page(Condition.getPage(query), Condition.getQueryWrapper(socialAccount));
		return R.data(pages);
	}

	/**
	 * 自定义分页 社交账号表
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入socialAccount")
	public R<IPage<SocialAccountVO>> page(SocialAccountVO socialAccount, Query query) {
		IPage<SocialAccountVO> pages = socialAccountService.selectSocialAccountPage(Condition.getPage(query), socialAccount);
		return R.data(pages);
	}

	/**
	 * 新增 社交账号表
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入socialAccount")
	public R save(@Valid @RequestBody SocialAccount socialAccount) {
		return R.status(socialAccountService.save(socialAccount));
	}

	/**
	 * 修改 社交账号表
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入socialAccount")
	public R update(@Valid @RequestBody SocialAccount socialAccount) {
		return R.status(socialAccountService.updateById(socialAccount));
	}

	/**
	 * 新增或修改 社交账号表
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入socialAccount")
	public R submit(@Valid @RequestBody SocialAccount socialAccount) {
		return R.status(socialAccountService.saveOrUpdate(socialAccount));
	}


	/**
	 * 删除 社交账号表
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 8)
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestBody List<String> ids) {
		return R.status(socialAccountService.removeByIds(ids));
	}


}
