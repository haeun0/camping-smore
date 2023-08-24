package com.green.campingsmore.common.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "item")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@SuperBuilder
public class ItemEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false, columnDefinition = "BIGINT UNSIGNED", length = 20)
    private Long iitem;

    @JoinColumn(name = "iitemCategory")
    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private ItemCategoryEntity itemCategoryEntity;

    @Column(nullable = false, length = 100, name = "\"name\"")
    private String name;

    @Column(nullable = false, columnDefinition = "INT UNSIGNED", length = 10)
    private Long price;

    @Column
    private String info;

    @Column(nullable = false, length = 200)
    private String pic;

    @Column(nullable = false, columnDefinition = "TINYINT", length = 1)
    @ColumnDefault("1")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer delYn;
}
