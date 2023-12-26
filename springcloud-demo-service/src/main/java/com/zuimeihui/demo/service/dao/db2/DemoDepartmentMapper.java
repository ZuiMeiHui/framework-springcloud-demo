package com.zuimeihui.demo.service.dao.db2;

import org.apache.ibatis.annotations.Mapper;

import com.zuimeihui.demo.common.dto.DemoDepartmentDTO;
import com.zuimeihui.demo.common.dto.DemoDepartmentQueryDTO;
import com.zuimeihui.demo.service.base.BaseMapper;

/**
 * 部门表Mapper
 * 
 * @author 醉美会 ZuiMeiHui.com
 * @date 2023-12-03 11:22:47
 */
@Mapper
public interface DemoDepartmentMapper extends BaseMapper<DemoDepartmentDTO, DemoDepartmentQueryDTO> {

}