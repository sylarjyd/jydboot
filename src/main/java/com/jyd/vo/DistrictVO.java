package com.jyd.vo;

import com.jyd.entity.District;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;

/**
 * 区划视图实体类
 *
 * @author 
 * @since 2023-12-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "DistrictVO对象", description = "区划")
public class DistrictVO extends District {
	private static final long serialVersionUID = 1L;

}
