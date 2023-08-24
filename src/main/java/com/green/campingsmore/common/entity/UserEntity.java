package com.green.campingsmore.common.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.green.campingsmore.common.config.jpa.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Table(name = "user",uniqueConstraints = {@UniqueConstraint(name = "unique_user_user_id",columnNames = {"user_id"})})
@Data
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@DynamicInsert
public class UserEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false, columnDefinition = "BIGINT UNSIGNED", length = 20)
    private Long iuser;

    @Column(updatable = false,name = "user_id", nullable = false, length = 20)
    private String userid;

    @Column(nullable = false, length = 20)
    private String password;

    @Column(nullable = false, length = 50)
    @Size(min = 2, max = 50)
    private String email;

    @Column(nullable = false,length = 20)
    private String name;

    @Column(nullable = false,length = 20)
    private String birthDate;

    @Column(nullable = false,length = 11)
    private String phone;

    @Column(columnDefinition = "TINYINT not null CHECK(gender in (0,1))",length = 1)
    private Integer gender;

    @Column(nullable = false, length = 100)
    private String userAddress;

    @Column(length = 100)
    private String userAddressDetail;

    @Column(nullable = false, length = 10)
    @ColumnDefault("'USER'")
    private String role;


    private String pic;

    @Column(length = 1, columnDefinition = "TINYINT")
    @ColumnDefault("1")
    @JsonIgnore
    private int delyn;
}