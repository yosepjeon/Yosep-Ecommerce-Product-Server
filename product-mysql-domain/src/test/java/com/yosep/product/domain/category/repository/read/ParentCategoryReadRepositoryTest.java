package com.yosep.product.domain.category.repository.read;

import com.yosep.product.domain.annotation.RepositoryTest;
import com.yosep.product.domain.category.entity.ParentCategory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

@RepositoryTest
@ActiveProfiles("test")
class ParentCategoryReadRepositoryTest {

	@Autowired
	private ParentCategoryReadRepository parentCategoryReadRepository;

	@Test
	@DisplayName("parentCategory_저장테스트_성공")
	void parentCategory_저장테스트_성공() {

		ParentCategory parentCategory = ParentCategory.builder()
			.categoryName("parentCategory1")
			.build();

		ParentCategory savedParentCategory = parentCategoryReadRepository.save(parentCategory);

		Assertions.assertEquals(parentCategory.getCategoryName(), savedParentCategory.getCategoryName());
	}
}