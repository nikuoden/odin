package com.odin.management.controller;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.odin.api.services.ArticleService;
import com.odin.management.autoconfigure.security.SecurityUser;
import com.odin.management.model.PostArticleModel;

/**
 * 管理画面初期表示コントローラークラス
 *
 * @author k_tsuji
 *
 */
@RequestMapping("management")
@Controller
public class ManagementController {

	@Autowired
	private ArticleService articleService;

	/**
	 * 初期表示
	 *
	 * @param name
	 * @param model
	 * @return
	 */
	@RequestMapping("")
	public String index() {
		return "management/index/home";
	}

	/**
	 * 記事指定表示
	 *
	 * @param name
	 * @param model
	 * @return
	 */
	@RequestMapping("/{articleId}")
	public String index(@PathVariable(value = "articleId") String articleId, Model model) {
		return "management/index/home";
	}

	/**
	 * 新規投稿 初期表示
	 *
	 * @param name
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String editArticle() {
		return "management/edit/edit";
	}

	/**
	 * 記事編集 初期表示
	 *
	 * @param name
	 * @param model
	 *
	 * @return
	 */
	@RequestMapping(value = "/edit/{articleId}", method = RequestMethod.GET)
	public String editArticle(@PathVariable(value = "articleId") Integer articleId, Model model) {
		model.addAttribute("article", articleId);
		return "management/edit/edit";
	}

	/**
	 * 記事編集 保存処理
	 *
	 * @param name
	 * @param model
	 *
	 */
	@RequestMapping(value = "/edit/{articleId}", method = RequestMethod.POST)
	public String saveArticle(@PathVariable(value = "articleId") Integer articleId, PostArticleModel postArticleModel) {
		// ログイン中のユーザーを投稿者として設定
		SecurityUser user =(SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		postArticleModel.setArticleAuthorId(user.getId());
		// 更新
		articleService.saveArticle(postArticleModel);
		return "redirect:/management/";
	}

	/**
	 * 新規投稿 保存処理
	 *
	 * @param name
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String saveArticle(PostArticleModel postArticleModel, Principal principal) {
		// ログイン中のユーザーを投稿者として設定
		SecurityUser user =(SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		postArticleModel.setArticleAuthorId(user.getId());
		// 更新
		articleService.saveArticle(postArticleModel);
		return "redirect:/management/";
	}

}