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

    private WebClient webClient;
    public UserService(WebClient webClient) {
        this.webClient = webClient;
    }
    private static final String USERS_URL_TEMPLATE = "/users/{id}";



    public Mono<User> getUserByIdAsync(final String id) {
        return webClient
                .get()
                .uri(USERS_URL_TEMPLATE, id)
                .retrieve()
                .bodyToMono(User.class);
    }
}
