package com.zuimeihui.demo.common.dto;

import java.io.Serializable;
import java.util.Date;

import com.zuimeihui.demo.common.PageCustom;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Tolerate;

/**
 * 用户表queryDTO
 * 
 * @ClassName: DemoUserQueryDTO
 * @Description: TODO
 * @author ZuiMeiHui.com 醉美会
 */
@Setter
@Getter
@ToString
@Builder
public class DemoUserQueryDTO extends PageCustom implements Serializable {

	private static final long serialVersionUID = 1L;

	@Tolerate
	public DemoUserQueryDTO() {

	}

	private Long id;

	private Date timeCreateBegin;

	private Date timeCreateEnd;

	private Date timeUpdateBegin;

	private Date timeUpdateEnd;

	private String name;

	private Boolean freeze;

}