package com.odin.api.services;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odin.api.Exception.NotFoundException;
import com.odin.api.domain.Articles;
import com.odin.api.entities.Article;
import com.odin.management.model.PostArticleModel;
import com.odin.management.services.UserService;

/**
 * 記事取得サービスクラス
 *
 * @author k_tsuji
 *
 */
@Service
public class ArticleService {

	@Autowired
	Articles articles;

	@Autowired
	UserService userService;

	/**
	 * 全記事を取得します。<br>
	 * 強制モードの場合、未公開のものも取得します。
	 *
	 * @param force
	 * @return
	 */
	public List<Article> getAllArticles(Boolean force) {
		List<Article> resultList;
		if (force) {
			resultList = articles.getAllArticles();
		} else {
			resultList = articles.getAllPublicArticles();
		}
		return resultList;
	}

	/**
	 * 指定した記事を取得します。
	 *
	 * @param articleId
	 * @return
	 */
	public Article getArticle(Integer articleId) {
		return articles.getArticle(articleId);
	}

	/**
	 * 指定されたurlに該当する記事を取得します。
	 *
	 * @param url
	 * @return
	 * @throws NotFoundException
	 */
	public Article getArticle(String url) {
		if(StringUtils.isEmpty(url)){
			throw new NotFoundException();
		}

		Article article = articles.getArticle(url);
		if(article == null){
			throw new NotFoundException();
		}

		return article;
	}

	/**
	 * 指定された記事を保存します。<br>
	 * 存在しない記事IDが指定された場合、新規保存されます。
	 *
	 * @param postArticleModel
	 */
	@Transactional
	public void saveArticle(PostArticleModel postArticleModel) {
		if(this.existsArticle(postArticleModel.getArticleId())){
			// 更新
			articles.updateArticle(postArticleModel);
		} else {
			// 新規作成
			articles.insertArticle(postArticleModel);
		}
	}

	/**
	 * 指定された記事が存在するかチェックします。
	 *
	 * @param articleId
	 * @return
	 */
	private boolean existsArticle(Integer articleId) {
		Article article = articles.getArticle(articleId);
		if (article == null) {
			return false;
		} else {
			return true;
		}
	}
}
