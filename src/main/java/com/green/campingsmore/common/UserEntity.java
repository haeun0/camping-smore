package com.green.campingsmore.common;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "\"user\"", uniqueConstraints = {
        @UniqueConstraint(
                name = "unique_user_user_id",
                columnNames = {"userId"})})
@Data
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UserEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false, columnDefinition = "BIGINT UNSIGNED", length = 15)
    private Long iuser;

    @Column(nullable =false, length = 20)
    private String userId;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 20, name = "\"name\"")
    private String name;

    @Column(nullable = false, length = 10)
    private String birthDate;

    @Column(nullable = false, length = 11)
    private String phone;

    @Column(nullable = false, length = 1, columnDefinition = "TINYINT CHECK (gender in (0,1)")
    @ColumnDefault("0")
    private Long gender;

    @Column(nullable = false, length = 100)
    private String userAddress;

    @Column(length = 100)
    private String userAddressDetail;

    @Column(nullable = false, length = 10)
    @ColumnDefault("0")
    private String role;

    @Column(length = 100)
    private String pic;

    @Column(length = 1, columnDefinition = "TINYINT")
    @ColumnDefault("1")
    @JsonIgnore
    private Long delYn;
}