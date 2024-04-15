package com.yosep.product.domain.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@SuperBuilder
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public abstract class BaseEntity extends AutoIncPkEntity{
    @Column(name = "insert_operator", updatable = false)
    protected String insertOperator;

    @Column(name = "update_operator")
    protected String updateOperator;

    @Column(name = "insert_time", updatable = false)
    protected LocalDateTime insertTime;

    @Column(name = "update_time")
    protected LocalDateTime updateTime;

    @Column(name = "delete_time")
    protected LocalDateTime deleteTime;

    @Column(name = "delete_check")
    private boolean isDeleted;
}
