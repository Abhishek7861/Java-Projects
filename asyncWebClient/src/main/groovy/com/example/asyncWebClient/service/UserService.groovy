package com.example.asyncWebClient.service

import com.example.asyncWebClient.model.User
import lombok.AllArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Service
@AllArgsConstructor
@Slf4j
class UserService {
    @Autowired
    WebClient webClient;
    private static final String USERS_URL_TEMPLATE = "/users";



    public Mono<User> getUserByIdAsync(final String id) {
        return webClient
                .get()
                .uri(USERS_URL_TEMPLATE)
                .retrieve()
                .bodyToMono(User.class);
    }
}
