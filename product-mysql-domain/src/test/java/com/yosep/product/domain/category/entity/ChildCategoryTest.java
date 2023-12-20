package com.yosep.product.domain.category.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ChildCategoryTest {

	@Test
	void testEquals() {
		// Given
		ParentCategory parentCategory = new ParentCategory("parentCategory");

		ChildCategory childCategory1 = new ChildCategory("childCategory1", parentCategory);
		ChildCategory childCategory2 = new ChildCategory();
		ChildCategory childCategory3 = ChildCategory.builder()
			.categoryName("childCategory3")
			.parentCategory(parentCategory)
			.build();

		// When & Then
		assertNotEquals(childCategory1, childCategory2);
		assertNotEquals(childCategory1.getCategoryName(), childCategory3.getCategoryName());
		assertEquals(childCategory1.getParentCategory(), childCategory3.getParentCategory());
	}
}