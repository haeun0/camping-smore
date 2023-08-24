package com.green.campingsmore.common.entity;

import com.green.campingsmore.common.config.jpa.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "item_detail_pic")
@Data
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ItemDetailPicEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false, columnDefinition = "BIGINT UNSIGNED", length = 20)
    private Long idetail;

    @JoinColumn(name = "iitem")
    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private ItemEntity itemEntity;

    @Column(nullable = false, length = 200)
    private String pic;
}
