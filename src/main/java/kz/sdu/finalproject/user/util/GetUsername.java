package kz.sdu.finalproject.user.util;

import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Component
public class GetUsername {

    public String getUsername(String token){
        String base64Credentials = token.substring("Basic ".length()).trim();
        byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
        String credentials = new String(credDecoded, StandardCharsets.UTF_8);

        final String[] values = credentials.split(":", 2);

        System.out.println(values[0]);

        return values[0];
    }

}
