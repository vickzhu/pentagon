package com.pentagon.web.article.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gandalf.framework.util.StringUtil;
import com.gandalf.framework.web.tool.Page;
import com.pentagon.biz.dao.model.Article;
import com.pentagon.biz.dao.model.ArticleCategory;
import com.pentagon.biz.dao.model.ArticleExample;
import com.pentagon.biz.dao.model.User;
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
		String curPageStr = request.getParameter("curPage");
		int curPage = 1;
		if(StringUtil.isNotBlank(curPageStr)) {
			curPage = Integer.valueOf(curPageStr);
		}
		int cpp = 10;
		List<ArticleCategory> acList = categoryService.selectAllFromCache();
		Map<Long, String> acMap = new HashMap<Long, String>();
		for (ArticleCategory articleCategory : acList) {
			acMap.put(articleCategory.getId(), articleCategory.getCategory());
		}
		Page<Article> page = new Page<Article>(curPage, cpp);
		ArticleExample example = new ArticleExample();
		example.setOrderByClause("id desc");
		articleService.selectByPagination(example, page);
		ModelAndView mav = new ModelAndView("article/articleList");
		mav.addObject("page", page);
		mav.addObject("categoryMap", acMap);
		mav.addObject("categoryList", acList);
		return mav;
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
	public String doAdd(HttpServletRequest request) {
		Long category = Long.valueOf(request.getParameter("category"));
		Integer display = Integer.valueOf(request.getParameter("display"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Article a = new Article();
		a.setCategory(category);
		a.setContent(content);
		a.setDisplay(display);
		a.setTitle(title);
		User user = (User)request.getSession().getAttribute("user");
		a.setUserId(user.getId());
		articleService.insertSelective(a);
		return "redirect:/article/all";
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
