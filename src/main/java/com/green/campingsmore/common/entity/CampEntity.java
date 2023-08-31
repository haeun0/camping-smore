package com.green.campingsmore.common.entity;

import com.green.campingsmore.common.config.jpa.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;


@Entity
@Table(name = "camp")
@Data
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
public class CampEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false,nullable = false,columnDefinition = "BIGINT UNSIGNED")
    private Long icamp;

    @Column(nullable = false)
    private String name;

    @Column(updatable = false,nullable = false)
    private String city;

    @Column(updatable = false,nullable = false)
    private String address;


    @Column(name = "main_pic",nullable = false)
    private String mainPic;

    @Column(name = "camp_phone",nullable = false)
    @Size(min = 9,max = 20)
    private String campPhone;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false,length = 2)
    private Integer capacity;

    @Column(nullable = false)
    private String note;
}
