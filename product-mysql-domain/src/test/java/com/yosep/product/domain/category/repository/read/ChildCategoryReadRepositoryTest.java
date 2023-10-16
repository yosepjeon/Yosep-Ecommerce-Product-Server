package com.yosep.product.domain.category.repository.read;

import static org.junit.jupiter.api.Assertions.*;

import com.yosep.product.domain.annotation.RepositoryTest;
import com.yosep.product.domain.category.entity.ChildCategory;
import com.yosep.product.domain.category.entity.ParentCategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

@RepositoryTest
@ActiveProfiles("test")
class ChildCategoryReadRepositoryTest {

	@Autowired
	private ParentCategoryReadRepository parentCategoryReadRepository;
	@Autowired
	private ChildCategoryReadRepository childCategoryReadRepository;
	private ParentCategory savedParentCategory;

	@BeforeEach
	void initParentCategory() {
		ParentCategory parentCategory = ParentCategory.builder()
			.categoryName("parentCategory1")
			.build();

		savedParentCategory = parentCategoryReadRepository.save(parentCategory);
	}

	@Test
	void childCategory_저장테스트_성공() {
		// Given
		ChildCategory childCategory = ChildCategory.builder()
			.categoryName("childCategoryTest")
			.parentCategory(savedParentCategory)
			.build();

		// When
		ChildCategory savedChildCategory = childCategoryReadRepository.save(childCategory);

		// Then
		assertEquals(childCategory.getParentCategory(), savedChildCategory.getParentCategory());
		assertEquals(childCategory.getCategoryName(), savedChildCategory.getCategoryName());
	}
}