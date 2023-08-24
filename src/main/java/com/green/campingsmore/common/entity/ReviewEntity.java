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
@Table(name = "review")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@SuperBuilder
public class ReviewEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false, columnDefinition = "BIGINT UNSIGNED", length = 20)
    private Long ireview;

    @JoinColumn(name = "iuser")
    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity userEntity;

    @JoinColumn(name = "iorder")
    @ManyToOne(fetch = FetchType.LAZY)
    private OrderEntity orderEntity;

    @JoinColumn(name = "iitem")
    @ManyToOne(fetch = FetchType.LAZY)
    private ItemEntity itemEntity;

    @Column(nullable = false, length = 200)
    private String reviewCtnt;

    @Column(length = 200)
    private String pic;

    @Column(nullable = false, columnDefinition = "TINYINT", length = 1)
    @ColumnDefault("5")
    private Integer starRating;

    @Column(columnDefinition = "INT UNSIGNED", length = 10)
    private Long reviewLike;

    @Column(nullable = false, columnDefinition = "TINYINT", length = 1)
    @ColumnDefault("1")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer delYn;

}