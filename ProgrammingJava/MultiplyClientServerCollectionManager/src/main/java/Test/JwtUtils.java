package Test;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtils {
	
	private static final String SECRET_KEY = "your-secret-key";
	
	public static String generateJwtToken() throws UnsupportedEncodingException {
		Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
		
		// Установка данных (payload) токена
		Map<String, Object> claims = new HashMap<>();
		
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.HOUR, 1); // Установка времени истечения токена через 1 час
		
		// Генерация токена
		String token = JWT.create()
				.withIssuer("your-issuer")
				.withSubject("your-subject")
				.withIssuedAt(new Date())
				.withExpiresAt(calendar.getTime())
				.withClaim("userId", 123)
				.withClaim("username", "john.doe")
				.sign(algorithm);
		
		return token;
	}
	
	public static void validateJwtToken(String token) throws UnsupportedEncodingException {
		Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
		DecodedJWT jwt = JWT.require(algorithm).build().verify(token);
		
		// Получение данных из токена
		String issuer = jwt.getIssuer();
		String subject = jwt.getSubject();
		Date issuedAt = jwt.getIssuedAt();
		Date expiresAt = jwt.getExpiresAt();
		Map<String, Claim> claims = jwt.getClaims();
		
		// Доступ к данным из claims
		int userId = claims.get("userId").asInt();
		String username = claims.get("username").asString();
		
		System.out.println("Токен верифицирован.");
		System.out.println("Issuer: " + issuer);
		System.out.println("Subject: " + subject);
		System.out.println("Issued At: " + issuedAt);
		System.out.println("Expires At: " + expiresAt);
		System.out.println("User ID: " + userId);
		System.out.println("Username: " + username);
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		String token = generateJwtToken();
		System.out.println("Сгенерированный JWT-токен: " + token);
		
		validateJwtToken(token);
	}
}