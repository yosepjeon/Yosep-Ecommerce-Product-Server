package com.yosep.product.domain.category.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ParentCategoryTest {


	@Test
	void testEquals() {
		ParentCategory parentCategory1 = new ParentCategory(1, "parentCategory1");
		ParentCategory parentCategory2 = new ParentCategory(1, "parentCategory1");
		ParentCategory parentCategory3 = ParentCategory.builder()
			.id(1)
			.categoryName("parentCategory2")
			.build();
		ParentCategory parentCategory4 = new ParentCategory();

		assertEquals(parentCategory1, parentCategory2);
		assertNotEquals(parentCategory1, parentCategory3);
		assertNotEquals(parentCategory1, parentCategory4);
	}
}