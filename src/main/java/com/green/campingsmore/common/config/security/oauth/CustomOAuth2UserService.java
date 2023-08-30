package com.green.campingsmore.common.config.security.oauth;

import com.green.campingsmore.common.config.exception.OAuthProviderMissMatchException;
import com.green.campingsmore.common.config.security.model.ProviderType;
import com.green.campingsmore.common.config.security.model.RoleType;
import com.green.campingsmore.common.config.security.model.UserPrincipal;
import com.green.campingsmore.common.config.security.oauth.userinfo.OAuth2UserInfo;
import com.green.campingsmore.common.config.security.oauth.userinfo.OAuth2UserInfoFactory;
import com.green.campingsmore.common.entity.UserEntity;
import com.green.campingsmore.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {
    private final UserRepository rep;

//    @Override
//    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
//        OAuth2User user = super.loadUser(userRequest);
//
//        try {
//            return this.process(userRequest, user);
//        } catch (AuthenticationException ex) {
//            throw ex;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            throw new InternalAuthenticationServiceException(ex.getMessage(), ex.getCause());
//        }
//    }
//
//    private OAuth2User process(OAuth2UserRequest userRequest, OAuth2User user) {
//        ProviderType providerType = ProviderType.valueOf(userRequest.getClientRegistration().getRegistrationId().toUpperCase());
//
//        OAuth2UserInfo userInfo = OAuth2UserInfoFactory.getOAuth2UserInfo(providerType, user.getAttributes());
//        UserEntity savedUser = rep.findByProviderTypeAndUid(providerType, userInfo.getId());
//
//        if (savedUser != null) {
//            if (providerType != savedUser.getProviderType()) {
//                throw new OAuthProviderMissMatchException(
//                        "Looks like you're signed up with " + providerType +
//                                " account. Please use your " + savedUser.getProviderType() + " account to login."
//                );
//            }
//            updateUser(savedUser, userInfo);
//        } else {
//            savedUser = createUser(userInfo, providerType);
//        }
//
//        return UserPrincipal.create(savedUser, user.getAttributes());
//    }
//
//    private UserEntity createUser(OAuth2UserInfo userInfo, ProviderType providerType) {
//
//        return rep.saveAndFlush(UserEntity.builder()
//                        .providerType(providerType)
//                        .uid(userInfo.getId())
//                        .unm(userInfo.getName())
//                        .roleType(RoleType.USER)
//                        .email(userInfo.getEmail())
//                        .pic(userInfo.getImageUrl())
//                .build());
//    }
//
//    private UserEntity updateUser(UserEntity user, OAuth2UserInfo userInfo) {
//        if (userInfo.getName() != null && !user.getUnm().equals(userInfo.getName())) {
//            user.setUnm(userInfo.getName());
//        }
//        if (userInfo.getImageUrl() != null && !user.getPic().equals(userInfo.getImageUrl())) {
//            user.setPic(userInfo.getImageUrl());
//        }
//        return user;
//    }
}
