package com.odin.api.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.odin.api.entities.Category;
import com.odin.api.repositories.CategoryRepository;

@Component
public class Categories {

	@Autowired
	private CategoryRepository categoryRepository;

	/**
	 * 公開中・非公開の記事を全て取得します。
	 *
	 * @return
	 */
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}
}
