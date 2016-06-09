package com.odin.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odin.api.domain.Categories;
import com.odin.api.entities.Category;

/**
 * 記事取得サービスクラス
 *
 * @author k_tsuji
 *
 */
@Service
public class CategoryService {

	@Autowired
	Categories categories;

	/**
	 * 全記事を取得します。<br>
	 * 強制モードの場合、未公開のものも取得します。
	 *
	 * @param force
	 * @return
	 */
	public List<Category> getAllCategories() {
		return categories.getAllCategories();
	}
}
