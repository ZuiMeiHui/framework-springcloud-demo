package com.zuimeihui.demo.common.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 部门表POJO
 * 
 * @ClassName: DemoDepartment
 * @Description: TODO
 * @author ZuiMeiHui.com 醉美会
 */
@Setter
@Getter
@ToString
public class DemoDepartment implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private Date timeCreate;

	private Date timeUpdate;

	private String adminId;

	private String adminName;

	private Long upId;

	private String name;

	private Boolean freeze;

	private String remark;

}