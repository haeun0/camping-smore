package com.green.campingsmore.common.entity;

import com.green.campingsmore.common.config.jpa.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "board_image")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@SuperBuilder
public class BoardImageEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false, columnDefinition = "BIGINT UNSIGNED")
    private Long iboardPic;

    @JoinColumn(name = "iboard",nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private BoardEntity boardEntity;

    @Column(nullable = false, length = 200)
    private String pic;
}
