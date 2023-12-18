package com.yosep.product.domain.product.repository.write;

import com.yosep.product.domain.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductWriteRepository extends JpaRepository<Product, Long> {

}
