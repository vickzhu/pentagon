package com.pentagon.web.op.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pentagon.biz.dto.ResourceTree;
import com.pentagon.biz.service.ResourceService;
import com.pentagon.web.controller.BaseController;

@Controller
@RequestMapping(value = "/op/role")
public class RoleController extends BaseController {
	
	@Autowired
	private ResourceService resourceService;

	@RequestMapping(value = "/resources", method = RequestMethod.GET)
	public ModelAndView roleResource(HttpServletRequest request,@RequestParam Long roleId) {
		ModelAndView mav = new ModelAndView("op/roleResource");
		List<ResourceTree> resourceList = resourceService.selectAllFromCache();
		mav.addObject("resourceList", resourceList);
		mav.addObject("roleId", roleId);
		return mav;
	}
	
}
