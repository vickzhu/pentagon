package com.pentagon.web.op.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pentagon.web.constant.User;
import com.pentagon.web.controller.BaseController;

@Controller
@RequestMapping(value = "/op")
public class UserController extends BaseController {

	private static List<User> userList = new ArrayList<User>();
	static {
		userList.add(new User("张", "三", "张三"));
		userList.add(new User("李", "四", "李四"));
		userList.add(new User("王", "五", "王五"));
		userList.add(new User("赵", "六", "赵六"));
		userList.add(new User("初", "七", "初七"));
	}

	@RequestMapping(value = "/users")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("op/userList");
		mav.addObject("userList", userList);
		return mav;
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ModelAndView add(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("op/userAdd");
		return mav;
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String doAdd(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String first = request.getParameter("first");
		String last = request.getParameter("last");
		String handle = first + last;
		userList.add(new User(first, last, handle));
		return "forward:/op/users";
	}
}
