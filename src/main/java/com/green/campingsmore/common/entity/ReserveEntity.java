package com.green.campingsmore.common.entity;

import com.green.campingsmore.common.config.jpa.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "reserve")
@Data
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ReserveEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false,nullable = false,columnDefinition = "BIGINT UNSIGNED")
    private Long ireserved;

    @Column(nullable = false)
    private LocalDate reservation;

    @Column(nullable = false)
    @Size(min = 2)
    private String name;

    @Column(nullable = false,length = 11)
    @Size(min = 11)
    private String phone;

    @Column(nullable = false)
    private Integer price;

    @Column(name = "pay_type",nullable = false)
    @Enumerated(EnumType.STRING)
    private PayType payType;

    @Column(name = "pay_status",nullable = false)
    @Enumerated(EnumType.STRING)
    private PayStatus payStatus;

    @ManyToOne
    @JoinColumn(name = "camp_id")
    private CampEntity campEntity;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;
}
