package com.zuimeihui.demo.service.user;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.zuimeihui.demo.common.dto.DemoUserDTO;
import com.zuimeihui.demo.common.dto.DemoUserQueryDTO;
import com.zuimeihui.demo.service.base.BaseService;
import com.zuimeihui.demo.service.dao.db1.DemoUserMapper;

/**
 * 用户表，服务层
 * 
 * @author 醉美会 ZuiMeiHui.com
 * @date 2023-11-12 20:29:00
 */
@Service
public class DemoUserService extends BaseService<DemoUserMapper, DemoUserDTO, DemoUserQueryDTO> {

	/**
	 * 保存和更新
	 */
	public Long save(DemoUserDTO dto, String userId, String userName) {
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
