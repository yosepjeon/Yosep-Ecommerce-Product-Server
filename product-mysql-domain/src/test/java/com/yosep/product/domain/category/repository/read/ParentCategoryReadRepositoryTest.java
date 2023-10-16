package com.yosep.product.domain.category.repository.read;

import static org.junit.jupiter.api.Assertions.*;

import com.yosep.product.domain.annotation.RepositoryTest;
import com.yosep.product.domain.category.entity.ParentCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

@RepositoryTest
@ActiveProfiles("test")
class ParentCategoryReadRepositoryTest {

	@Autowired
	private ParentCategoryReadRepository parentCategoryReadRepository;

	@Test
	void parentCategory_저장테스트_성공() {

		ParentCategory parentCategory = ParentCategory.builder()
			.categoryName("parentCategory1")
			.build();

		ParentCategory savedParentCategory = parentCategoryReadRepository.save(parentCategory);

		assertEquals(parentCategory.getCategoryName(), savedParentCategory.getCategoryName());
	}
}