package com.zuimeihui.demo.web.controller.department;

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
import com.zuimeihui.demo.web.service.IDemoDepartmentService;

/**
 * 部门控制器
 * 
 * @ClassName: DemoDepartmentController
 * @Description: TODO
 * @author ZuiMeiHui.com 醉美会
 */
@RestController
@RequestMapping("/demo-department")
public class DemoDepartmentController {

	@Autowired
	private IDemoDepartmentService demoDepartmentService;

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
			@RequestBody DemoDepartmentQueryDTO queryDTO) {
		queryDTO.setFields("id");
		queryDTO.setOrder("desc");
		return demoDepartmentService.listPage(userId, userName, queryDTO);
	}

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
			@RequestBody DemoDepartmentQueryDTO queryDTO) {
		queryDTO.setFields("id");
		queryDTO.setOrder("desc");
		return demoDepartmentService.list(userId, userName, queryDTO);
	}

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
			@RequestBody DemoDepartmentDTO dto) {
		return demoDepartmentService.add(userId, userName, dto);
	}

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
	@PutMapping({ "{id}/edit" })
	public ApiResult<?> edit(@RequestParam(value = Constants.USER_ID_KEY, required = false) String userId,
			@RequestParam(value = Constants.USER_NAME_KEY, required = false) String userName,
			@RequestBody DemoDepartmentDTO dto, @PathVariable("id") Long id) {
		dto.setId(id);
		return demoDepartmentService.edit(userId, userName, dto, id);
	}

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
	@GetMapping({ "{id}/detail" })
	public ApiResult<?> detail(@RequestParam(value = Constants.USER_ID_KEY, required = false) String userId,
			@RequestParam(value = Constants.USER_NAME_KEY, required = false) String userName,
			@PathVariable("id") Long id) {
		return demoDepartmentService.detail(userId, userName, id);
	}

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
	@DeleteMapping({ "{id}/delete" })
	public ApiResult<?> delete(@RequestParam(value = Constants.USER_ID_KEY, required = false) String userId,
			@RequestParam(value = Constants.USER_NAME_KEY, required = false) String userName,
			@PathVariable("id") Long id) {
		return demoDepartmentService.delete(userId, userName, id);
	}
}