package sked.ecommerce.security;

import java.security.Key;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import sked.ecommerce.service.UserDetailsImpl;
import sked.ecommerce.service.UserDetailsServiceImpl;

@Component
public class JwtUtils {
  private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

  @Value("${sked.ecommerce.jwt.secret}")
  private String jwtSecret;

  @Value("${sked.ecommerce.jwt.expiration}")
  private int jwtExpirationMs;

  private final UserDetailsServiceImpl userDetailsService;

  public JwtUtils(UserDetailsServiceImpl userDetailsService) {
    this.userDetailsService = userDetailsService;
  }

  public String generateJwtToken(Authentication authentication) {
    UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
    String hashedPassword = BCrypt.hashpw(userPrincipal.getPassword(), BCrypt.gensalt(12));
    Date expiryDate = new Date((new Date()).getTime() + jwtExpirationMs);

    return Jwts.builder()
        .setSubject(userPrincipal.getUsername())
        .claim("pw", hashedPassword)
        .claim("email", userPrincipal.getUsername())
        .setIssuedAt(new Date())
        .setExpiration(expiryDate)
        .signWith(key(), SignatureAlgorithm.HS256)
        .compact();
  }

  private Key key() {
    return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
  }

  public String getUserNameFromJwtToken(String token) {
    return Jwts.parserBuilder().setSigningKey(key()).build()
        .parseClaimsJws(token).getBody().getSubject();
  }

  public boolean validateJwtToken(String authToken) {
    try {
      Jws<Claims> claims = Jwts.parserBuilder().setSigningKey(key()).build().parseClaimsJws(authToken);
      String email = claims.getBody().get("email", String.class);
      UserDetailsImpl userDetails = (UserDetailsImpl) userDetailsService.loadUserByUsername(email);
      String storedPasswordHash = claims.getBody().get("pw", String.class);
      return BCrypt.checkpw(userDetails.getPassword(), storedPasswordHash);
    } catch (JwtException | IllegalArgumentException e) {
      logger.error("Invalid JWT token: {}", e.getMessage());
    }
    return false;
  }
}
