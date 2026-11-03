package br.com.adbrascosmopolis.saac_secretaria.config;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestClient;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Configuration
public class SecretariaRestClientConfig {

    @Bean("secretariaRestClient")
    RestClient secretariaRestClient(
            RestClient.Builder builder,
            @Value("${secretaria.api.base-url}") String baseUrl) {

        return builder
                .baseUrl(baseUrl)
                .requestInterceptor((request, body, execution) -> {
                    var attributes =
                            RequestContextHolder.getRequestAttributes();

                    if (attributes instanceof ServletRequestAttributes servletAttributes) {
                        HttpServletRequest incomingRequest =
                                servletAttributes.getRequest();

                        String authorization =
                                incomingRequest.getHeader(HttpHeaders.AUTHORIZATION);

                        if (authorization != null
                                && authorization.regionMatches(
                                true, 0, "Bearer ", 0, 7)) {
                            request.getHeaders().set(
                                    HttpHeaders.AUTHORIZATION,
                                    authorization
                            );
                        }
                    }

                    return execution.execute(request, body);
                })
                .build();
    }
}

