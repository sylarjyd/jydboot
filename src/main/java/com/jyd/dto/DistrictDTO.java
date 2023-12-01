package com.jyd.dto;

import com.jyd.entity.District;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 区划数据传输对象实体类
 *
 * @author 
 * @since 2023-12-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DistrictDTO extends District {
	private static final long serialVersionUID = 1L;

}
