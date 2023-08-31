package com.green.campingsmore.common.config.security;

import com.green.campingsmore.common.config.exception.TokenValidFailedException;
import com.green.campingsmore.common.config.security.model.UserPrincipal;
import com.green.campingsmore.common.config.properties.AppProperties;
import com.green.campingsmore.common.config.security.model.AuthToken;
import com.green.campingsmore.common.config.security.model.LoginInfoVo;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.Key;

@Slf4j
@Component
@RequiredArgsConstructor
public class AuthTokenProvider {
    private final AppProperties appProperties;

    @PostConstruct
    private void init () {
        byte[] accessKeyBytes = Decoders.BASE64.decode(appProperties.getAuth().getAceessSecret());
        this.appProperties.setAccessTokenKey(Keys.hmacShaKeyFor(accessKeyBytes));

        byte[] refreshKeyBytes = Decoders.BASE64.decode(appProperties.getAuth().getRefreshSecret());
        this.appProperties.setRefreshTokenKey(Keys.hmacShaKeyFor(refreshKeyBytes));
    }

    public AuthToken createAccessToken(String id) {
        return createAccessToken(id, null);
    }

    public AuthToken createAccessToken(String id, LoginInfoVo vo) {
        long expiry = appProperties.getAuth().getAccessTokenExpiry();
        Key key = appProperties.getAccessTokenKey();
        return createToken(id, expiry, key, vo);
    }

    public AuthToken createRefreshToken(String id) {
        return createRefreshToken(id, null);
    }

    public AuthToken createRefreshToken(String id, LoginInfoVo vo) {
        long expiry = appProperties.getAuth().getRefreshTokenExpiry();
        Key key = appProperties.getRefreshTokenKey();
        return createToken(id, expiry, key, vo);
    }

    private AuthToken createToken(String id, long expiry, Key key, LoginInfoVo vo) {
        return vo == null ? new AuthToken(id, expiry, key) : new AuthToken(id, expiry, key, vo);
    }

    public AuthToken convertAuthToken(String token, Key key) {
        return new AuthToken(token, key);
    }

    public Authentication getAuthentication(AuthToken authToken) {
        if(authToken.validate()) {
            UserPrincipal userPrincipal = authToken.getUserDetails();
            return new UsernamePasswordAuthenticationToken(userPrincipal, null, userPrincipal.getAuthorities());
        } else {
            throw new TokenValidFailedException();
        }
    }
}
