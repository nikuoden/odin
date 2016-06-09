package com.odin.management.model;

public class PostArticleModel {

	private Integer articleId;

	private String title;

	private String body;

	private String articleImage;

	private String articleUrl;

	private String category;

	private String tag;

	private String keyword;

	private Integer articleAuthorId;

	private Boolean publicFlag;

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Boolean getPublicFlag() {
		return publicFlag;
	}

	public void setPublicFlag(Boolean publicFlag) {
		this.publicFlag = publicFlag;
	}

	public String getArticleImage() {
		return articleImage;
	}

	public void setArticleImage(String articleImage) {
		this.articleImage = articleImage;
	}

	public String getArticleUrl() {
		return articleUrl;
	}

	public void setArticleUrl(String articleUrl) {
		this.articleUrl = articleUrl;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Integer getArticleAuthorId() {
		return articleAuthorId;
	}

	public void setArticleAuthorId(Integer articleAuthorId) {
		this.articleAuthorId = articleAuthorId;
	}
}
