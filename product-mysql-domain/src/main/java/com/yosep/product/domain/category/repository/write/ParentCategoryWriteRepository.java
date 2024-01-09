package com.yosep.product.domain.category.repository.write;

import com.yosep.product.domain.category.entity.ParentCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yosep
 * @since 2023-10-05
 */
public interface ParentCategoryWriteRepository extends JpaRepository<ParentCategory, Long> {

}
