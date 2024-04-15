package com.yosep.product.domain.product.repository.write;

import static org.junit.jupiter.api.Assertions.*;

import com.yosep.product.domain.annotation.RepositoryTest;
import com.yosep.product.domain.category.entity.ChildCategory;
import com.yosep.product.domain.category.entity.ParentCategory;
import com.yosep.product.domain.category.repository.write.ChildCategoryWriteRepository;
import com.yosep.product.domain.category.repository.write.ParentCategoryWriteRepository;
import com.yosep.product.domain.common.vo.Money;
import com.yosep.product.domain.product.entity.Product;
import com.yosep.product.domain.product.value.Stock;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

@RepositoryTest
@ActiveProfiles("test")
class ProductWriteRepositoryTest {

    @Autowired
    private ParentCategoryWriteRepository parentCategoryWriteRepository;
    @Autowired
    private ChildCategoryWriteRepository childCategoryWriteRepository;
    @Autowired
    private ProductWriteRepository productWriteRepository;

    @Test
    void 저장테스트() {
        // Given
        String productNameMock = "product1";
        long sellerIdMock = 1;
        Money priceMock = new Money(10000);
        Stock stockMock = new Stock(10, 10);
        ParentCategory parentCategoryMock = ParentCategory.builder()
                .categoryName("바지")
                .build();
        ParentCategory savedParentCategory = parentCategoryWriteRepository.save(parentCategoryMock);
        ChildCategory childCategoryMock = ChildCategory.builder()
                .parentCategory(savedParentCategory)
                .categoryName("청바지")
                .build();
        ChildCategory savedChildCategory = childCategoryWriteRepository.save(childCategoryMock);
        boolean isDeletedMock = false;
        String insertOperatorMock = "전요셉";
        LocalDateTime now = LocalDateTime.now();

        Product expected = Product.builder()
                .productName(productNameMock)
                .sellerId(sellerIdMock)
                .price(priceMock)
                .stockQuantity(stockMock)
                .parentCategory(savedParentCategory)
                .childCategory(savedChildCategory)
                .isDeleted(isDeletedMock)
                .insertOperator(insertOperatorMock)
                .updateOperator(insertOperatorMock)
                .insertTime(now)
                .updateTime(now)
                .deleteTime(now)
                .build();

        // When
        Product actual = productWriteRepository.save(expected);

        // Then
        assertEquals(expected.getProductName(), actual.getProductName());
    }
}