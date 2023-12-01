package com.jyd.dto;

import com.jyd.entity.SysNotice;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 新闻公告数据传输对象实体类
 *
 * @author 
 * @since 2023-12-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysNoticeDTO extends SysNotice {
	private static final long serialVersionUID = 1L;

}
