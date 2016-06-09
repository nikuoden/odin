package com.odin.api.controller;

import java.util.List;

import javassist.NotFoundException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.odin.api.entities.Article;
import com.odin.api.services.ArticleService;

/**
 * 記事コントローラ<br>
 * 記事の取得処理をメインとしています。
 *
 * @author k_tsuji
 */
@RestController
public class ArticleController {

	@Autowired
	private ArticleService articleService;

	/**
	 * 全ての記事を取得する。
	 *
	 * @return
	 */
	@RequestMapping(value="api/article/", method=RequestMethod.GET)
	public List<Article> getArticles(HttpServletRequest req) {
		Boolean force = new Boolean(req.getParameter("force"));
		return articleService.getAllArticles(force);
	}

	/**
	 * 指定された記事IDの記事を取得する。
	 *
	 * @param articleId
	 * @return
	 */
	@RequestMapping(value="api/article/{articleId}", method=RequestMethod.GET)
	public Article getArticle(@PathVariable("articleId") Integer articleId) {
		return articleService.getArticle(articleId);
	}

	/**
	 * 指定されたカテゴリーの記事を取得する。
	 *
	 * @param カテゴリーID
	 * @return
	 */
	@RequestMapping(value="api/article/category/{categoryId}", method=RequestMethod.GET)
	public Article getArticleByCategory(@PathVariable("categoryId") Integer categoryId) {
		return articleService.getArticle(categoryId);
	}

	/**
	 * 指定されたカテゴリーの記事を取得する。
	 *
	 * @param カテゴリーID
	 * @return
	 * @throws NotFoundException
	 */
	@RequestMapping(value="api/article/url/{url}", method=RequestMethod.GET)
	public Article getArticleByCategory(@PathVariable("url") String url) {
		return articleService.getArticle(url);
	}
}