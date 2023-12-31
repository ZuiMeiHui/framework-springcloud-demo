package com.zuimeihui.demo.web.utils;

import org.springframework.stereotype.Service;

import com.zuimeihui.demo.common.dto.DemoUserDTO;

/**
 * 鉴权用户是否登陆
 * 
 * @ClassName: OAuthService
 * @Description: TODO
 * @author ZuiMeiHui.com 醉美会
 */
@Service
public class OAuthService {

	/**
	 * 对Token鉴权
	 * 
	 * @Title: checkToken
	 * @Description: TODO
	 * @param @param  token
	 * @param @return 参数
	 * @return DemoUserDTO 返回类型
	 * @throws
	 * @author ZuiMeiHui.com 醉美会
	 */
	public DemoUserDTO checkToken(String token) {
		// 例子，具体鉴权方法需根据用户接口自行实现
		DemoUserDTO demoUserDTO = new DemoUserDTO();
		demoUserDTO.setId(1L);
		demoUserDTO.setName("LiYang");
		return demoUserDTO;
	}
}
