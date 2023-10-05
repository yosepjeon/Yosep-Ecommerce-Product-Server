package com.yosep.product.domain.category.repository;

import com.yosep.product.domain.category.entity.ParentCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yosep
 * @since 2023-10-05
 */
public interface ParentCategoryRepository extends JpaRepository<ParentCategory, Long> {

}
