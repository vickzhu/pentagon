package com.pentagon.web.op.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gandalf.framework.web.tool.AjaxResult;
import com.pentagon.biz.dao.model.Role;
import com.pentagon.biz.dao.model.RoleExample;
import com.pentagon.biz.dto.ResourceTree;
import com.pentagon.biz.service.ResourceService;
import com.pentagon.biz.service.RoleService;
import com.pentagon.web.controller.BaseController;

@Controller
@RequestMapping(value = "/op/role")
public class RoleController extends BaseController {
	
	@Autowired
	private ResourceService resourceService;
	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("op/roleList");
		RoleExample example = new RoleExample();
		example.setOrderByClause(" id desc ");
		List<Role> roleList = roleService.selectByExample(example);
		mav.addObject("roleList", roleList);
		return mav;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("op/roleAdd");
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public AjaxResult doAdd(HttpServletRequest request) {
		Role role = new Role();
		role.setRoleName(request.getParameter("roleName"));
		role.setEnable(Integer.valueOf(request.getParameter("enable")));
		int count = roleService.insertSelective(role);
		return new AjaxResult(count == 1, null);
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(HttpServletRequest request, @RequestParam Long roleId) {
		Role role = roleService.selectByPrimaryKey(roleId);
		ModelAndView mav = new ModelAndView("op/roleEdit");
		mav.addObject("role", role);
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public AjaxResult doEdit(HttpServletRequest request) {
		Role role = new Role();
		role.setId(Long.valueOf(request.getParameter("roleId")));
		role.setRoleName(request.getParameter("roleName"));
		role.setEnable(Integer.valueOf(request.getParameter("enable")));
		int count = roleService.updateByPrimaryKeySelective(role);
		return new AjaxResult(count == 1, null);
	}

	@RequestMapping(value = "/resources", method = RequestMethod.GET)
	public ModelAndView roleResource(HttpServletRequest request,@RequestParam Long roleId) {
		ModelAndView mav = new ModelAndView("op/roleResource");
		List<ResourceTree> resourceList = resourceService.selectAllFromCache();
		mav.addObject("resourceList", resourceList);
		mav.addObject("roleId", roleId);
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value = "/resources", method = RequestMethod.POST)
	public AjaxResult saveRoleResource(HttpServletRequest request) {
		String roleId = request.getParameter("roleId");
		String[] resources = request.getParameterValues("res");
		return new AjaxResult(true, null);
	}
	
}
