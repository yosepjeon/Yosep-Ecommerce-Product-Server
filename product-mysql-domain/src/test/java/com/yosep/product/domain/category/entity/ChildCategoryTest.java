package com.yosep.product.domain.category.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ChildCategoryTest {

	@Test
	void testEquals() {
		ParentCategory parentCategory = new ParentCategory(1, "parentCategory");

		ChildCategory childCategory1 = new ChildCategory(1, "childCategory1", parentCategory);
		ChildCategory childCategory2 = new ChildCategory();
		ChildCategory childCategory3 = ChildCategory.builder()
			.id(3)
			.categoryName("childCategory3")
			.parentCategory(parentCategory)
			.build();

		assertNotEquals(childCategory1, childCategory2);
		assertNotEquals(childCategory1.getCategoryName(), childCategory3.getCategoryName());
		assertEquals(childCategory1.getParentCategory(), childCategory3.getParentCategory());
	}
}