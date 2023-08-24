package com.green.campingsmore.common.entity;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "item_category")
@Data
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)

public class ItemCategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iitem_category", updatable = false, nullable = false, columnDefinition = "BIGINT UNSIGNED")
    private Long iitemCategory;

    @Column(name = "\"name\"", nullable = false, length = 50)
    private String name;
}
