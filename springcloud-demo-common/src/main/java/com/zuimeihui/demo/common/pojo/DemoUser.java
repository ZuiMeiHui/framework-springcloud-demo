package com.zuimeihui.demo.common.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 用户表POJO
 * 
 * @ClassName: DemoUser
 * @Description: TODO
 * @author ZuiMeiHui.com 醉美会
 */
@Setter
@Getter
@ToString
public class DemoUser implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private Date timeCreate;

	private Date timeUpdate;

	private String adminId;

	private String adminName;

	private String name;

	private Integer age;

	private Integer sex;

	private String mobilePhone;

	private String email;

	private Boolean freeze;

	private String remark;

}