package com.green.campingsmore.common.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "cart")
@Data
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class CartEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false, columnDefinition = "BIGINT UNSIGNED", length = 20)
    private Long icart;

    @JoinColumn(name = "iuser")
    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private UserEntity userEntity;

    @JoinColumn(name = "iitem")
    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private ItemEntity itemEntity;

    @Column(nullable = false, columnDefinition = "TINYINT", length = 2)
    private Long quantity;
}