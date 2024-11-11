package uth.edu.podbooking.domain.auth.service;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import lombok.Data;
import lombok.experimental.NonFinal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uth.edu.podbooking.domain.account.entity.Account;
import uth.edu.podbooking.domain.account.repository.AccountRepository;
import uth.edu.podbooking.domain.auth.dto.request.AuthTokenRequest;
import uth.edu.podbooking.domain.auth.dto.request.LoginRequest;
import uth.edu.podbooking.domain.auth.dto.respone.AuthTokenResponse;
import uth.edu.podbooking.domain.auth.dto.respone.LoginResponse;
import uth.edu.podbooking.domain.auth.mapper.LoginMapper;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Data
public class LoginService {
    private final LoginMapper loginMapper;
    private final PasswordEncoder passwordEncoder;
    private final AccountRepository accountRepository;
    private static final Logger logger = LoggerFactory.getLogger(LoginService.class);

    LoginService(LoginMapper loginMapper, PasswordEncoder passwordEncoder, AccountRepository accountRepository) {
        this.loginMapper = loginMapper;
        this.passwordEncoder = passwordEncoder;
        this.accountRepository = accountRepository;
    }

    @NonFinal
    @Value("${jwt.signerKey}")
    protected  String secret;

    public LoginResponse auth(LoginRequest loginRequest) {
        Optional<Account> accountOptional = this.accountRepository.findByEmail(loginRequest.getEmail());
        if (accountOptional.isEmpty()) {
            return new LoginResponse(false, "");
        }
        if (!passwordEncoder.matches(loginRequest.getPassword(), accountOptional.get().getPassword())) {
            return new LoginResponse(false, "");
        }

        Optional<String> token = generateToken(loginRequest.getEmail());
        return new LoginResponse(true, token.get());
    }

    public Optional<String> generateToken(String email) {
        // hearder
        JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);
        Date expirationTime = new Date(new Date().getTime() + 3600 * 1000);
        List<String> permissions = Arrays.asList("READ", "WRITE");

        // payload
        // tìm Email => check Role + permission
        JWTClaimsSet claims = new JWTClaimsSet.Builder()
                .subject(email)
                .issuer("uth.edu.podbooking")
                .expirationTime(expirationTime)// Thời gian hết hạn
                .claim("permission", permissions.get(0))
                .claim("role", "ADMIN") // Claim vai trò
                .build();

        // Tạo SignedJWT và ký token

        SignedJWT signedJWT = new SignedJWT(header, claims);
        byte[] sharedSecret = secret.getBytes(StandardCharsets.UTF_8);

        try {
            // 1 instance để kí
            JWSSigner signer = new MACSigner(sharedSecret);

            signedJWT.sign(signer);
        } catch (JOSEException e) {
            logger.error(e.getMessage());
            throw new RuntimeException(e);
        }
        return Optional.of(signedJWT.serialize());
    }

    // check token -> check hết hạn chưa
    public AuthTokenResponse checkToken(AuthTokenRequest authTokenRequest) {
        String clientToken = authTokenRequest.getToken();
        try {
            JWSVerifier verifier = new MACVerifier(this.secret.getBytes());
            SignedJWT signedJWT = null;

            try {
                signedJWT = SignedJWT.parse(clientToken);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            // Xác thực token
            if (signedJWT.verify(verifier)) {
                try {
                    JWTClaimsSet claimsSet = signedJWT.getJWTClaimsSet();

                    // Lấy thời gian hiện tại
                    Date now = new Date();

                    // Lấy thời gian hết hạn từ claim 'exp'
                    Date expirationTime = claimsSet.getExpirationTime();

                    // không có time or expirationTime < now => het han
                    if (expirationTime != null && expirationTime.before(now)) {
                        // Token đã hết hạn
                        return new AuthTokenResponse(false);
                    }

                    // Token hợp lệ và chưa hết hạn
                    String subject = claimsSet.getSubject();

                    // Tạo và trả về phản hồi
                    return new AuthTokenResponse(true);

                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            } else {
                // Token không hợp lệ
                return new AuthTokenResponse(false);
            }
        } catch (JOSEException e) {
            throw new RuntimeException(e);
        }

    }

}

