package com.green.campingsmore.common.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.green.campingsmore.common.config.jpa.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "board")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@SuperBuilder
public class BoardEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, columnDefinition = "BIGINT UNSIGNED")
    @NotNull
    private Long iboard;

    @JoinColumn(name = "iuser")
    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    @NotNull
    private UserEntity userEntity;

    @JoinColumn(name = "icategory")
    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    @NotNull
    private BoardCategoryEntity boardCategoryEntity;

    @Column(length = 20)
    private String title;

    @Column(nullable = false, length = 300)
    private String ctnt;

    @Column(nullable = false, columnDefinition = "TINYINT", length = 1)
    @ColumnDefault("1")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer delYn;

    @Column(updatable = false, nullable = false, columnDefinition = "BIGINT UNSIGNED", length = 20)
    @ColumnDefault("0")
    private Long boardView;
}