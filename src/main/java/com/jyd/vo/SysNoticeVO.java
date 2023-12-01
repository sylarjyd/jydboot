package com.jyd.vo;

import com.jyd.entity.SysNotice;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 新闻公告视图实体类
 *
 * @author 
 * @since 2023-12-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SysNoticeVO对象", description = "新闻公告")
public class SysNoticeVO extends SysNotice {
	private static final long serialVersionUID = 1L;

}
