package com.green.campingsmore.common;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "comment")
@Data
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ItemDetailPicEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false, columnDefinition = "BIGINT UNSIGNED", length = 15)
    private Long idetail;

    @JoinColumn(name = "iitem")
    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private ItemEntity itemEntity;

    @Column(nullable = false, length = 200)
    private String pic;
}
