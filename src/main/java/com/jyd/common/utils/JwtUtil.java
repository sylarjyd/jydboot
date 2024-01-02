package com.jyd.common.utils;

import cn.hutool.core.util.IdUtil;
import com.jyd.common.constant.CommonConstants;
import com.jyd.config.security.LoginConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;

@Component
@Slf4j
@Data
public class JwtUtil {

    @Resource
    private LoginConfig loginConfig;

    public String getUUID(){
        return IdUtil.simpleUUID();
    }

    public String createJwt(String subject, String userid){
        JwtBuilder builder = getJwtBuilder(subject, getUUID(), userid);
        return builder.compact();
    }

    private JwtBuilder getJwtBuilder(String subject, String uuid, String userId) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        SecretKey secretKey = generalKey();
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        long expMillis = nowMillis + loginConfig.getExpire()*1000;
        Date expDate = new Date(expMillis);
        return Jwts.builder()
                .setId(uuid)
                .setSubject(subject)
                .setIssuer(CommonConstants.AUTHOR)
                .setIssuedAt(now)
                .signWith(signatureAlgorithm, secretKey)
                .setExpiration(expDate)
                .claim(CommonConstants.USER_ID, userId);
    }

    /**
     * 生成加密后的秘钥 secretKey
     * @return
     */
    public SecretKey generalKey() {
        byte[] encodedKey = Base64.getDecoder().decode(loginConfig.getSecret());
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }

    /**
     * 解析
     * @param jwt
     * @return
     * @throws Exception
     */
    public Claims parseJWT(String jwt) throws Exception {
        SecretKey secretKey = generalKey();
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(jwt)
                .getBody();
    }
}
