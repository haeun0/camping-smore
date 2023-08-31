package com.green.campingsmore.user;

import com.green.campingsmore.common.config.security.model.ProviderType;
import com.green.campingsmore.common.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByProviderTypeAndUid(ProviderType providerType, String uid);
}
