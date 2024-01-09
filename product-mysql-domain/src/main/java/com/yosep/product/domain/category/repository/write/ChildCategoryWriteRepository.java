package com.yosep.product.domain.category.repository.write;

import com.yosep.product.domain.category.entity.ChildCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yosep
 * @since 2023-10-16
 */
public interface ChildCategoryWriteRepository extends JpaRepository<ChildCategory, Long> {

}
