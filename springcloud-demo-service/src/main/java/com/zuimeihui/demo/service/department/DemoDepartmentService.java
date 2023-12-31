package com.zuimeihui.demo.service.department;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.zuimeihui.demo.common.dto.DemoDepartmentDTO;
import com.zuimeihui.demo.common.dto.DemoDepartmentQueryDTO;
import com.zuimeihui.demo.service.base.BaseService;
import com.zuimeihui.demo.service.dao.db2.DemoDepartmentMapper;

/**
 * 部门服务层
 * 
 * @ClassName: DemoDepartmentService
 * @Description: TODO
 * @author ZuiMeiHui.com 醉美会
 */
@Service
public class DemoDepartmentService extends BaseService<DemoDepartmentMapper, DemoDepartmentDTO, DemoDepartmentQueryDTO> {

	/**
	 * 保存和更新
	 * 
	 * @Title: save
	 * @Description: TODO
	 * @param @param  dto
	 * @param @param  userId
	 * @param @param  userName
	 * @param @return 参数
	 * @return Long 返回类型
	 * @throws
	 * @author ZuiMeiHui.com 醉美会
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
