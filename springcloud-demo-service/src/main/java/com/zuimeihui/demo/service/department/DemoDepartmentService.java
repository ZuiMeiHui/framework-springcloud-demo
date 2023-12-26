package com.zuimeihui.demo.service.department;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.zuimeihui.demo.common.dto.DemoDepartmentDTO;
import com.zuimeihui.demo.common.dto.DemoDepartmentQueryDTO;
import com.zuimeihui.demo.service.base.BaseService;
import com.zuimeihui.demo.service.dao.db2.DemoDepartmentMapper;

/**
 * 部门表，服务层
 * 
 * @author 醉美会 ZuiMeiHui.com
 * @date 2023-11-12 20:29:00
 */
@Service
public class DemoDepartmentService extends BaseService<DemoDepartmentMapper, DemoDepartmentDTO, DemoDepartmentQueryDTO> {

	/**
	 * 保存和更新
	 */
	public Long save(DemoDepartmentDTO dto, String userId, String userName) {
		dto.setAdminId(userId);
		dto.setAdminName(userName);
		dto.setTimeUpdate(new Date());
		if (dto.getId() == null) {
			dto.setTimeCreate(new Date());
			dto.setFreeze(false);
			mapper.insertSelective(dto);
		} else {
			mapper.updateByPrimaryKeySelective(dto);
		}
		return dto.getId();
	}

}
