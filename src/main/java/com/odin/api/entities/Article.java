package com.odin.api.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author k_tsuji
 */
@Entity
@Table(name = "article")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Article.findAll", query = "SELECT a FROM Article a"),
    @NamedQuery(name = "Article.findByArticleId", query = "SELECT a FROM Article a WHERE a.articleId = :articleId"),
    @NamedQuery(name = "Article.findByArticleImage", query = "SELECT a FROM Article a WHERE a.articleImage = :articleImage"),
    @NamedQuery(name = "Article.findByArticleUrl", query = "SELECT a FROM Article a WHERE a.articleUrl = :articleUrl"),
    @NamedQuery(name = "Article.findByPostDate", query = "SELECT a FROM Article a WHERE a.postDate = :postDate"),
    @NamedQuery(name = "Article.findByPublicFlag", query = "SELECT a FROM Article a WHERE a.publicFlag = :publicFlag")})
public class Article implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ARTICLE_ID")
    private Integer articleId;
    @Lob
    @Column(name = "TITLE")
    private String title;
    @Lob
    @Column(name = "BODY")
    private String body;
    @Column(name = "ARTICLE_IMAGE")
    private String articleImage;
    @Column(name = "ARTICLE_URL")
    private String articleUrl;
    @Column(name = "POST_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date postDate;
    @Column(name = "PUBLIC_FLAG")
    private Boolean publicFlag;
    @JoinTable(name = "article_tag", joinColumns = {
        @JoinColumn(name = "ARTICLE_ID", referencedColumnName = "ARTICLE_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "TAG_ID", referencedColumnName = "TAG_ID")})
    @ManyToMany
    private List<Tag> tagList;
    @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "CATEGORY_ID")
    @ManyToOne
    private Category categoryId;

    public Article() {
    }

    public Article(Integer articleId) {
        this.articleId = articleId;
    }

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

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public Boolean getPublicFlag() {
        return publicFlag;
    }

    public void setPublicFlag(Boolean publicFlag) {
        this.publicFlag = publicFlag;
    }

    @XmlTransient
    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (articleId != null ? articleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Article)) {
            return false;
        }
        Article other = (Article) object;
        if ((this.articleId == null && other.articleId != null) || (this.articleId != null && !this.articleId.equals(other.articleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.jpa1.Article[ articleId=" + articleId + " ]";
    }

}
