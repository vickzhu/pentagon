package com.pentagon.web.news.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pentagon.biz.dao.model.Article;
import com.pentagon.biz.dao.model.ArticleCategory;
import com.pentagon.biz.service.ArticleCategoryService;
import com.pentagon.biz.service.ArticleService;
import com.pentagon.web.controller.BaseController;

@Controller
@RequestMapping("/article")
public class ArticleController extends BaseController {
	
	@Resource
	private ArticleService articleService;
	@Resource
	private ArticleCategoryService categoryService;

	/**
	 * 查看所有
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ModelAndView all(HttpServletRequest request) {
		
		return new ModelAndView();
	}
	
	/**
	 * 查看某个
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView one(HttpServletRequest request, @PathVariable Long id) {
		
		return new ModelAndView();
	}
	
	/**
	 * 新增页
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView add(HttpServletRequest request) {
		List<ArticleCategory> acList = categoryService.selectByExample(null);
		ModelAndView mav = new ModelAndView("article/articleAdd");		
		mav.addObject("categoryList", acList);
		return mav;
	}
	
	/**
	 * 新增页
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ModelAndView doAdd(HttpServletRequest request) {
		Integer category = Integer.valueOf(request.getParameter("category"));
		Integer display = Integer.valueOf(request.getParameter("display"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Article a = new Article();
		a.setCategory(category);
		a.setContent(content);
		a.setDisplay(display);
		a.setTitle(title);
		a.setUserId(null);
		articleService.insert(a);
		return new ModelAndView("article/articleList");
	}
	
	/**
	 * 编辑
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ModelAndView edit(HttpServletRequest request, @PathVariable Long id) {
		
		return new ModelAndView();
	}
	
	/**
	 * 删除
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ModelAndView delete(HttpServletRequest request, @PathVariable Long id) {
		
		return new ModelAndView();
	}
	
	
}
