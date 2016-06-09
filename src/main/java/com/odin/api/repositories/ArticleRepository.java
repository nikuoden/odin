package com.odin.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.odin.api.entities.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {

	@Query("SELECT a FROM Article a where a.articleId = ?1")
	Article findByArticleId(Integer articleId);

	@Query("SELECT a FROM Article a where a.publicFlag = true")
	List<Article> findAllPublicArticles();

	@Query("SELECT a FROM Article a where a.articleUrl = ?1")
	Article findByArticleUrl(String articleUrl);
}