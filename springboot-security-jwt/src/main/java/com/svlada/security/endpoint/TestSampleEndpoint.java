package com.svlada.security.endpoint;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.svlada.entity.User;
import com.svlada.security.UserService;
import com.svlada.security.auth.jwt.extractor.TokenExtractor;
import com.svlada.security.auth.jwt.verifier.TokenVerifier;
import com.svlada.security.config.JwtSettings;
import com.svlada.security.config.WebSecurityConfig;
import com.svlada.security.exceptions.InvalidJwtToken;
import com.svlada.security.model.UserContext;
import com.svlada.security.model.token.JwtToken;
import com.svlada.security.model.token.JwtTokenFactory;
import com.svlada.security.model.token.RawAccessJwtToken;
import com.svlada.security.model.token.RefreshToken;

/**
 * RefreshTokenEndpoint
 * 
 * @author vladimir.stankovic
 *
 * Aug 17, 2016
 */
@RestController
public class TestSampleEndpoint {
     
    
    @RequestMapping(value="/api/auth/test", method=RequestMethod.GET, produces={ MediaType.APPLICATION_JSON_VALUE })
    public @ResponseBody String refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
       

        return "this is a Test";
    }
}
