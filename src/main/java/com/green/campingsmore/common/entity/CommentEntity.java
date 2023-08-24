package com.green.campingsmore.common.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "comment")
@Data
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class CommentEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false, columnDefinition = "BIGINT UNSIGNED", length = 20)
    private Long icomment;

    @JoinColumn(name = "iboard")
    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private BoardEntity boardEntity;

    @JoinColumn(name = "iuser")
    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private UserEntity userEntity;

    @Column(nullable = false, length = 100)
    private Long ctnt;

    @Column(length = 1, columnDefinition = "TINYINT")
    @ColumnDefault("1")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer delYn;
}
