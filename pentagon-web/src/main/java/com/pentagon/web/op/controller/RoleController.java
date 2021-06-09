package com.pentagon.web.op.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pentagon.web.controller.BaseController;

@Controller
@RequestMapping(value = "/op/role")
public class RoleController extends BaseController {

	@RequestMapping(value = "/resources", method = RequestMethod.GET)
	public ModelAndView roleResource(HttpServletRequest request) {
		
		return new ModelAndView("op/roleResource");
	}
	
}
