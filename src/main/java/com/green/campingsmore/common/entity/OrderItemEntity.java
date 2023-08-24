package com.green.campingsmore.common.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.green.campingsmore.common.config.jpa.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "order_item")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@SuperBuilder
public class OrderItemEntity extends BaseEntity {
    @Id
    @JoinColumn(name = "iorder")
    @ManyToOne(fetch = FetchType.LAZY)
    private OrderEntity orderEntity;

    @Id
    @JoinColumn(name = "iitem")
    @ManyToOne(fetch = FetchType.LAZY)
    private ItemEntity itemEntity;

    @Column(nullable = false, columnDefinition = "INT UNSIGNED", length = 10)
    private Long price;

    @Column(nullable = false, columnDefinition = "TINYINT", length = 2)
    @ColumnDefault("1")
    private Long quantity;

    @Column(nullable = false, columnDefinition = "BIGINT UNSIGNED", length = 20)
    private Long totalPrice;

    @Column(nullable = false, columnDefinition = "TINYINT", length = 1)
    @ColumnDefault("0")
    private Long refund;

    @Column(nullable = false, columnDefinition = "TINYINT", length = 1)
    @ColumnDefault("1")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long delYn;
}