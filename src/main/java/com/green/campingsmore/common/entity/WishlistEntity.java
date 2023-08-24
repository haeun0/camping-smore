package com.green.campingsmore.common.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "wishlist")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@SuperBuilder
public class WishlistEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false, columnDefinition = "BIGINT UNSIGNED", length = 15)
    private Long iwish;

    @JoinColumn(name = "iuser")
    @ManyToOne
    private UserEntity userEntity;

    @JoinColumn(name = "iitem")
    @ManyToOne
    private ItemEntity itemEntity;

    @ColumnDefault("1")
    @JsonIgnore
    private Integer delYn;
}
