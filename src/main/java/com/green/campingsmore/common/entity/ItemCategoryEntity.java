package com.green.campingsmore.common.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "item_category")
@Data
@SuperBuilder
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ItemCategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iitem_category", updatable = false, nullable = false, columnDefinition = "BIGINT UNSIGNED", length = 20)
    private Long iitemCategory;

    @Column(nullable = false, length = 50, name = "\"name\"")
    private String name;
}
