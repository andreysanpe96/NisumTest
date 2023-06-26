package com.nisum.api.config.security;

import com.nisum.api.entity.UserEntity;
import com.nisum.api.repository.UserRepository;
import com.nisum.api.utils.jwt.JwtTokenValidator;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Optional;

@Component
@Slf4j
@RequiredArgsConstructor
public class JwtTokenInterceptor implements HandlerInterceptor {

    private final JwtTokenValidator tokenValidator;

    private final UserRepository userRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String uri = request.getRequestURI();
        if (uri.startsWith("/swagger-ui") || uri.startsWith("/v3/api-docs")) {
            return true;
        }
        return validateToken(request, response);
    }

    private boolean validateToken(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String token = request.getHeader("Authorization");
        if (token != null && token.startsWith("Bearer ")) {
            String jwtToken = token.substring(7);
            boolean isValidToken = tokenValidator.validateToken(jwtToken);
            if (isValidToken && isValidUser(jwtToken)) {
                return true;
            }
        }
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid Token");
        return false;
    }

    private boolean isValidUser(String jwt) {
        String email = tokenValidator.getUsernameFromToken(jwt);
        Optional<UserEntity> userEntity = userRepository.findByEmail(email);
        if (userEntity.isPresent()) {
            return userEntity.get().getIsActive();
        } else {
            return false;
        }
    }
}