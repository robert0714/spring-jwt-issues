package develop.api.jwt.security;

import org.junit.Test;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import develop.api.jwt.security.JwtAuthenticationProvider;
import develop.api.jwt.security.JwtAuthenticationToken;
import develop.api.jwt.user.UserRepository;

import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class JwtAuthenticationProviderTest {

  private JwtAuthenticationProvider subject = new JwtAuthenticationProvider("secret", mock(UserRepository.class));

  @Test
  public void testSupports() throws Exception {
    assertTrue(subject.supports(JwtAuthenticationToken.class));
    assertTrue(subject.supports(UsernamePasswordAuthenticationToken.class));

    assertFalse(subject.supports(AbstractAuthenticationToken.class));
    assertFalse(subject.supports(Object.class));
  }
}