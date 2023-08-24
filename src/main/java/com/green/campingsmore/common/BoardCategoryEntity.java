package com.green.campingsmore.common;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "board_category")
@Data
@NoArgsConstructor
@ToString
@SuperBuilder
public class BoardCategoryEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false, columnDefinition = "BIGINT UNSIGNED")
    private Long icategory;

    @Column(nullable = false, length = 20, name = "\"name\"")
    private String name;

}
