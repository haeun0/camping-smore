package com.green.campingsmore.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@SuperBuilder
@NoArgsConstructor
public class BaseEntity {
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;
//    =LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm:ss"))

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @LastModifiedDate
    private LocalDateTime updatedAt;
}
