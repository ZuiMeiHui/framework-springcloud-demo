package com.zuimeihui.demo.service.dao.db1;

import org.apache.ibatis.annotations.Mapper;

import com.zuimeihui.demo.common.dto.DemoUserDTO;
import com.zuimeihui.demo.common.dto.DemoUserQueryDTO;
import com.zuimeihui.demo.service.base.BaseMapper;

/**
 * 用户表Mapper
 * 
 * @ClassName: DemoUserMapper
 * @Description: TODO
 * @author ZuiMeiHui.com 醉美会
 */
@Mapper
public interface DemoUserMapper extends BaseMapper<DemoUserDTO, DemoUserQueryDTO> {

}