package com.example.library.security;

import com.example.library.utilities.CommonUtility;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;

import java.io.IOException;
import java.util.Properties;


public class AuthenticationService {
    public static CommonUtility commonUtility = new CommonUtility();
    public static Properties properties = new Properties();

    private static String AUTH_TOKEN_HEADER_NAME;
    private static String AUTH_TOKEN;

    public static Authentication getAuthentication(HttpServletRequest request) throws IOException {
        properties = commonUtility.getApiKey();
        AUTH_TOKEN = properties.getProperty("secret");
        AUTH_TOKEN_HEADER_NAME = properties.getProperty("header");
        String apiKey = request.getHeader(AUTH_TOKEN_HEADER_NAME);
        if (apiKey == null || !apiKey.equals(AUTH_TOKEN)) {
            throw new BadCredentialsException("Invalid API Key");
        }

        return new ApiKeyAuthentication(apiKey, AuthorityUtils.NO_AUTHORITIES);
    }
}
