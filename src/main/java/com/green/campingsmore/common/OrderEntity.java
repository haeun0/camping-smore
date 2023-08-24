package com.green.campingsmore.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "\"order\"")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@SuperBuilder
public class OrderEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false, columnDefinition = "BIGINT UNSIGNED", length = 15)
    private Long iorder;

    @JoinColumn(name = "iuser")
    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity userEntity;

    @Column(nullable = false, length = 100)
    private Long address;

    @Column(length = 100)
    private Long addressDetail;

    @Column(nullable = false, columnDefinition = "BIGINT UNSIGNED", length = 11)
    private Long totalPrice;

    @Column(length = 10, columnDefinition = "INT UNSIGNED")
    @ColumnDefault("3000")
    private Long shippingPrice;

    @Column(length = 10, columnDefinition = "INT UNSIGNED")
    private Long shippingMemo;

    @Column(nullable = false, columnDefinition = "TINYINT", length = 1)
    @ColumnDefault("1")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long delYn;
}
