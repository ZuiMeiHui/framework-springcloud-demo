package com.zuimeihui.demo.web.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.zuimeihui.demo.common.ApiResult;
import com.zuimeihui.demo.common.Constants;
import com.zuimeihui.demo.common.dto.DemoDepartmentDTO;
import com.zuimeihui.demo.common.dto.DemoDepartmentQueryDTO;

/**
 * 部门接口层
 * 
 * @ClassName: IDemoDepartmentService
 * @Description: TODO
 * @author ZuiMeiHui.com 醉美会
 */
@FeignClient(url = Constants.SPRINGCLOUD_PROVIDER_URL + "/demo-department", name = "IDemoDepartmentService")
public interface IDemoDepartmentService {

	/**
	 * 部门列表-带分页
	 * 
	 * @Title: listPage
	 * @Description: TODO
	 * @param @param  userId
	 * @param @param  userName
	 * @param @param  queryDTO
	 * @param @return 参数
	 * @return ApiResult<?> 返回类型
	 * @throws
	 * @author ZuiMeiHui.com 醉美会
	 */
	@PostMapping({ "/list/page" })
	public ApiResult<?> listPage(@RequestParam(value = Constants.USER_ID_KEY, required = false) String userId,
			@RequestParam(value = Constants.USER_NAME_KEY, required = false) String userName,
			@RequestBody DemoDepartmentQueryDTO queryDTO);

	/**
	 * 部门列表-不带分页
	 * 
	 * @Title: list
	 * @Description: TODO
	 * @param @param  userId
	 * @param @param  userName
	 * @param @param  queryDTO
	 * @param @return 参数
	 * @return ApiResult<?> 返回类型
	 * @throws
	 * @author ZuiMeiHui.com 醉美会
	 */
	@PostMapping({ "/list" })
	public ApiResult<?> list(@RequestParam(value = Constants.USER_ID_KEY, required = false) String userId,
			@RequestParam(value = Constants.USER_NAME_KEY, required = false) String userName,
			@RequestBody DemoDepartmentQueryDTO queryDTO);

	/**
	 * 部门新增
	 * 
	 * @Title: add
	 * @Description: TODO
	 * @param @param  userId
	 * @param @param  userName
	 * @param @param  dto
	 * @param @return 参数
	 * @return ApiResult<?> 返回类型
	 * @throws
	 * @author ZuiMeiHui.com 醉美会
	 */
	@PostMapping({ "/add" })
	public ApiResult<?> add(@RequestParam(value = Constants.USER_ID_KEY, required = false) String userId,
			@RequestParam(value = Constants.USER_NAME_KEY, required = false) String userName,
			@RequestBody DemoDepartmentDTO dto);

	/**
	 * 部门编辑
	 * 
	 * @Title: edit
	 * @Description: TODO
	 * @param @param  userId
	 * @param @param  userName
	 * @param @param  dto
	 * @param @param  id
	 * @param @return 参数
	 * @return ApiResult<?> 返回类型
	 * @throws
	 * @author ZuiMeiHui.com 醉美会
	 */
	@PutMapping({ "/{id}/edit" })
	public ApiResult<?> edit(@RequestParam(value = Constants.USER_ID_KEY, required = false) String userId,
			@RequestParam(value = Constants.USER_NAME_KEY, required = false) String userName,
			@RequestBody DemoDepartmentDTO dto, @PathVariable("id") Long id);

	/**
	 * 部门详情
	 * 
	 * @Title: detail
	 * @Description: TODO
	 * @param @param  userId
	 * @param @param  userName
	 * @param @param  id
	 * @param @return 参数
	 * @return ApiResult<?> 返回类型
	 * @throws
	 * @author ZuiMeiHui.com 醉美会
	 */
	@GetMapping({ "/{id}/detail" })
	public ApiResult<?> detail(@RequestParam(value = Constants.USER_ID_KEY, required = false) String userId,
			@RequestParam(value = Constants.USER_NAME_KEY, required = false) String userName,
			@PathVariable("id") Long id);

	/**
	 * 部门删除
	 * 
	 * @Title: delete
	 * @Description: TODO
	 * @param @param  userId
	 * @param @param  userName
	 * @param @param  id
	 * @param @return 参数
	 * @return ApiResult<?> 返回类型
	 * @throws
	 * @author ZuiMeiHui.com 醉美会
	 */
	@DeleteMapping({ "/{id}/delete" })
	public ApiResult<?> delete(@RequestParam(value = Constants.USER_ID_KEY, required = false) String userId,
			@RequestParam(value = Constants.USER_NAME_KEY, required = false) String userName,
			@PathVariable("id") Long id);

}
