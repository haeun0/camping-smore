package com.green.campingsmore.common;


import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "shipping_address")
@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString(callSuper = true)
@SuperBuilder
public class ShippingAddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false, columnDefinition = "BIGINT UNSIGNED", length = 15)
    private Long iaddress;

    @JoinColumn(name = "iuser")
    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity userEntity;

    @Column(nullable = false, length = 100)
    private String address;

    @Column(length = 100)
    private String addressDetail;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 11)
    private String phone;
}