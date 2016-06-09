package com.odin.api.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.odin.api.entities.Category;
import com.odin.api.services.CategoryService;

/**
 * カテゴリーコントローラ<br>
 * カテゴリー取得処理をメインとしています。
 *
 * @author k_tsuji
 */
@RestController
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	/**
	 * 全てのカテゴリーを取得する。
	 *
	 * @return
	 */
	@RequestMapping(value="api/category/", method=RequestMethod.GET)
	public List<Category> getArticles(HttpServletRequest req) {
		return categoryService.getAllCategories();
	}
}