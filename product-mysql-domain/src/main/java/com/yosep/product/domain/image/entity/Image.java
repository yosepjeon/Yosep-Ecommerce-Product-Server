package com.yosep.product.domain.image.entity;

import com.yosep.product.domain.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public abstract class Image extends BaseEntity {

    @Column(name = "url")
    protected String url;
}
