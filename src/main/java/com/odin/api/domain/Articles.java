package com.odin.api.domain;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.odin.api.entities.Article;
import com.odin.api.repositories.ArticleRepository;
import com.odin.management.model.PostArticleModel;

@Component
public class Articles {

	@Autowired
	private ArticleRepository articleRepository;

	/**
	 * 公開中・非公開の記事を全て取得します。
	 *
	 * @return
	 */
	public List<Article> getAllArticles() {
		return articleRepository.findAll();
	}

	/**
	 * 公開中の記事を全て取得します。
	 *
	 * @return
	 */
	public List<Article> getAllPublicArticles() {
		return articleRepository.findAllPublicArticles();
	}

	/**
	 * 指定した記事を取得します。
	 *
	 * @param articleId
	 * @return
	 */
	public Article getArticle(Integer articleId) {
		return articleRepository.findByArticleId(articleId);
	}

	/**
	 * 指定した記事を更新します。
	 *
	 * @param postArticleModel
	 */
	public void updateArticle(PostArticleModel postArticleModel) {
		Article article = new Article();
		article.setArticleId(postArticleModel.getArticleId());
		article.setTitle(postArticleModel.getTitle());
		article.setBody(postArticleModel.getBody());
		article.setArticleImage(postArticleModel.getArticleImage());

		if(StringUtils.isBlank(postArticleModel.getArticleUrl())){
			// 指定が無い場合はタイトルをURLとする。
			article.setArticleUrl(postArticleModel.getTitle());
		} else{
			article.setArticleUrl(postArticleModel.getArticleUrl());
		}
		article.setPublicFlag(postArticleModel.getPublicFlag());
		article.setPostDate(new Date());
		articleRepository.save(article);
	}

	/**
	 * 指定した記事を追加します。
	 *
	 * @param postArticleModel
	 */
	public void insertArticle(PostArticleModel postArticleModel) {
		Article article = new Article();
		article.setTitle(postArticleModel.getTitle());
		article.setBody(postArticleModel.getBody());
		article.setArticleImage(postArticleModel.getArticleImage());

		if(StringUtils.isBlank(postArticleModel.getArticleUrl())){
			// 指定が無い場合はタイトルをURLとする。
			article.setArticleUrl(postArticleModel.getTitle());
		} else{
			article.setArticleUrl(postArticleModel.getArticleUrl());
		}
		article.setPublicFlag(postArticleModel.getPublicFlag());
		article.setPostDate(new Date());
		articleRepository.save(article);
	}

	/**
	 *
	 *
	 * @param url
	 * @return
	 */
	public Article getArticle(String url) {
		return articleRepository.findByArticleUrl(url);
	}
}
