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
 * 部门表，接口层
 * 
 * @author 醉美会 ZuiMeiHui.com
 * @date 2023-11-12 20:29:00
 */
@FeignClient(url = Constants.SPRINGCLOUD_PROVIDER_URL + "/demo-department", name = "IDemoDepartmentService")
public interface IDemoDepartmentService {
	
	/**
	 * 列表-带分页
	 * 
	 * @param queryDTO
	 * @return
	 */
	@PostMapping({ "/list/page" })
	public ApiResult<?> listPage(
			@RequestParam(value= Constants.USER_ID_KEY, required = false) String userId,
			@RequestParam(value= Constants.USER_NAME_KEY, required = false) String userName,
			@RequestBody DemoDepartmentQueryDTO queryDTO) ;

	/**
	 * 列表-不带分页
	 * 
	 * @param queryDTO
	 * @return
	 */
	@PostMapping({ "/list" })
	public ApiResult<?> list(
			@RequestParam(value= Constants.USER_ID_KEY, required = false) String userId,
			@RequestParam(value= Constants.USER_NAME_KEY, required = false) String userName,
			@RequestBody DemoDepartmentQueryDTO queryDTO) ;

	/**
	 * 新增
	 * 
	 * @param dto
	 * @return
	 */
	@PostMapping({ "/add" })
	public ApiResult<?> add(
			@RequestParam(value= Constants.USER_ID_KEY, required = false) String userId,
			@RequestParam(value= Constants.USER_NAME_KEY, required = false) String userName,
			@RequestBody DemoDepartmentDTO dto) ;

	/**
	 * 编辑
	 * 
	 * @param dto
	 * @param id
	 * @return
	 */
	@PutMapping({ "/{id}/edit" })
	public ApiResult<?> edit(
			@RequestParam(value= Constants.USER_ID_KEY, required = false) String userId,
			@RequestParam(value= Constants.USER_NAME_KEY, required = false) String userName,
			@RequestBody DemoDepartmentDTO dto, 
			@PathVariable("id") Long id) ;

	/**
	 * 详情
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping({ "/{id}/detail" })
	public ApiResult<?> detail(
			@RequestParam(value= Constants.USER_ID_KEY, required = false) String userId,
			@RequestParam(value= Constants.USER_NAME_KEY, required = false) String userName,
			@PathVariable("id") Long id) ;

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping({ "/{id}/delete" })
	public ApiResult<?> delete(
			@RequestParam(value= Constants.USER_ID_KEY, required = false) String userId,
			@RequestParam(value= Constants.USER_NAME_KEY, required = false) String userName,
			@PathVariable("id") Long id) ;
	
}
