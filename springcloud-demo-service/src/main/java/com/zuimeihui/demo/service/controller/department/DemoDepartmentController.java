package com.zuimeihui.demo.service.controller.department;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zuimeihui.demo.common.ApiResult;
import com.zuimeihui.demo.common.Constants;
import com.zuimeihui.demo.common.dto.DemoDepartmentDTO;
import com.zuimeihui.demo.common.dto.DemoDepartmentQueryDTO;
import com.zuimeihui.demo.service.department.DemoDepartmentService;

/**
 * DemoDepartmentController
 * 
 * @author 醉美会 ZuiMeiHui.com
 * @date 2023-11-12 20:49:53
 */
@RestController
@RequestMapping("/demo-department")
public class DemoDepartmentController {

	@Autowired
	private DemoDepartmentService demoDepartmentService;

	/**
	 * 列表-带分页
	 * 
	 * @param queryDTO
	 * @return
	 */
	@PostMapping({ "/list/page" })
	public ApiResult<?> listPage(@RequestParam(value = Constants.USER_ID_KEY, required = false) String userId,
			@RequestParam(value = Constants.USER_NAME_KEY, required = false) String userName,
			@RequestBody DemoDepartmentQueryDTO queryDTO) {
		queryDTO.setFields("id");
		queryDTO.setOrder("desc");
		return ApiResult.success(demoDepartmentService.selectPageBy(queryDTO));
	}

	/**
	 * 列表-不带分页
	 * 
	 * @param queryDTO
	 * @return
	 */
	@PostMapping({ "/list" })
	public ApiResult<?> list(@RequestParam(value = Constants.USER_ID_KEY, required = false) String userId,
			@RequestParam(value = Constants.USER_NAME_KEY, required = false) String userName,
			@RequestBody DemoDepartmentQueryDTO queryDTO) {
		queryDTO.setFields("id");
		queryDTO.setOrder("desc");
		List<DemoDepartmentDTO> demoDepartmentDTOs = demoDepartmentService.selectBy(queryDTO);
		return ApiResult.success(demoDepartmentDTOs);
	}

	/**
	 * 新增
	 * 
	 * @param dto
	 * @return
	 */
	@PostMapping({ "/add" })
	public ApiResult<?> add(@RequestParam(value = Constants.USER_ID_KEY, required = false) String userId,
			@RequestParam(value = Constants.USER_NAME_KEY, required = false) String userName,
			@RequestBody DemoDepartmentDTO dto) {
		Long id = demoDepartmentService.save(dto, userId, userName);
		return ApiResult.success(id);
	}

	/**
	 * 编辑
	 * 
	 * @param dto
	 * @param id
	 * @return
	 */
	@PutMapping({ "/{id}/edit" })
	public ApiResult<?> edit(@RequestParam(value = Constants.USER_ID_KEY, required = false) String userId,
			@RequestParam(value = Constants.USER_NAME_KEY, required = false) String userName,
			@RequestBody DemoDepartmentDTO dto, @PathVariable("id") Long id) {
		dto.setId(id);
		demoDepartmentService.save(dto, userId, userName);
		return ApiResult.success(dto.getId());
	}

	/**
	 * 详情
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping({ "/{id}/detail" })
	public ApiResult<?> detail(@RequestParam(value = Constants.USER_ID_KEY, required = false) String userId,
			@RequestParam(value = Constants.USER_NAME_KEY, required = false) String userName,
			@PathVariable("id") Long id) {
		DemoDepartmentDTO demoDepartmentDTO = demoDepartmentService.get(id);
		return ApiResult.success(demoDepartmentDTO);
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping({ "/{id}/delete" })
	public ApiResult<?> delete(@RequestParam(value = Constants.USER_ID_KEY, required = false) String userId,
			@RequestParam(value = Constants.USER_NAME_KEY, required = false) String userName,
			@PathVariable("id") Long id) {
		demoDepartmentService.remove(id);
		return ApiResult.success(id);
	}

}